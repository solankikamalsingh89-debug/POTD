package Leetcode_POTD.June_2026;
/*
I traverse descriptions, for every: Created node if has not made(both parent and child)(by checkinh hashmap node- Then add newly made node in it)
In hashmap, i store node's value(to search for it in O(1)), a array of TreeNode-->{Cur_Node, Highest parent node till then created and connected to it}
We also update with hashmap if root node is with them till max height to finally get root Node.
TC - O(n^2), SC - O(n)  (Also number of operation per iterations were a lot in number)

My way looks clumsy, so Cleaner Code:
HashMap for val, and its node refernce -> If node is node created- create it and assign respective child of them in each descriptions--> Maintaining Tree
Also HashSet for children: Root can't be a children- so used this to get root Node in end
TC - O(n), SC - O(n)

New Learning: putIfAbsent(): The putIfAbsent(K key, V value) method in Java inserts a key-value pair into a Map only if the specified key is not already present or is currently mapped to null.
              Return: Integer(Final value of key)-->Null , if key was mapped with null or was absent earlier
                                                    Value , if key was mapped with value V- finally value remains same- returns V 
*/

import java.util.*;
import javax.swing.tree.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class June_7 {

    public TreeNode createBinaryTree1(int[][] descriptions) { //CleanCode
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] des : descriptions) {
            map.putIfAbsent(des[0], new TreeNode(des[0]));
            map.putIfAbsent(des[1], new TreeNode(des[1]));
            if (des[2] == 1) map.get(des[0]).left = map.get(des[1]);
            else map.get(des[0]).right = map.get(des[1]);
            children.add(des[1]);
        }
        for (int[] des : descriptions) {
            if (!children.contains(des[0])) return map.get(des[0]);
        }
        return null;
    }

    public TreeNode createBinaryTree(int[][] descriptions) { //MyCode
        HashMap<Integer,TreeNode[]> node=new HashMap<>();
        TreeNode root=new TreeNode(descriptions[0][0]);
        node.put(descriptions[0][0],new TreeNode[]{root,root});
        node.put(descriptions[0][1],new TreeNode[]{new TreeNode(descriptions[0][1]),root});
        if(descriptions[0][2]==1) root.left=node.get(descriptions[0][1])[0];
        else root.right=node.get(descriptions[0][1])[0];

        for(int a[]: descriptions){
            if(node.containsKey(a[0])){
                if(!node.containsKey(a[1])) node.put(a[1],new TreeNode[]{new TreeNode(a[1]),null});
                if(a[2]==1) node.get(a[0])[0].left=node.get(a[1])[0];
                else node.get(a[0])[0].right=node.get(a[1])[0];
                node.get(a[1])[1]=node.get(a[0])[1];
            }
            else{
                if(!node.containsKey(a[1])) node.put(a[1],new TreeNode[]{new TreeNode(a[1]),null});
                if(a[2]==1) node.put(a[0],new TreeNode[]{new TreeNode(a[0],node.get(a[1])[0],null),null});
                else node.put(a[0],new TreeNode[]{new TreeNode(a[0],null,node.get(a[1])[0]),null});
                node.get(a[1])[1]=node.get(a[0])[1]=node.get(a[0])[0];
            }       
            if(root==node.get(a[1])[0]) root=node.get(a[1])[1]=node.get(a[0])[1];
            while(node.get(root.val)[1]!=node.get(root.val)[0]) root=node.get(root.val)[1];
        }
        return root;
    }
}
