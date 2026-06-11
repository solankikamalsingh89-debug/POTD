package Leetcode_POTD.June_2026;
/*
Two main concerns in quetion:
1.Traversing whole tree to get max_height
2.By max_height find the number of ways weight is odd

1.We have 2 options:
i)DFS: (Done by Java Code)
    -I tried something similar firstly with HashMap(in place of array) of integer(node name) and its connected nodes(parent and children) as HashSet(in place of ArrayList)
     for O(n), O(1) was costing many operation like two removals if any edge is evaluated, multiple iterator for hashset each time
    -So later i switched to usual DFS to over come TLE(Array of arraylist for neighbours of node), also here i used parent to avoid back traversal
ii)BFS: (Done by Java Code)
    -Making a queue to maitain BFS starting from root(1) and their height with firstly setting up Array of arraylist for neighbours of node, then foing BFS to get max_depth at end

2.As number of 1 should be odd:
 nC1+nC3+nC5+..... all odd terms=> 2^(n-1)
 To overcome range we are alloted in java for any datatype we may use BigInteger or may do multiplication handling base 2 by modulus check with each multiplication
*/
import java.util.ArrayList;
import java.util.HashSet;

public class June_11 {
    public int max_depth=0;
    public int assignEdgeWeights(int[][] edges) {
        //return h2(edges);
        return h1(edges);
    }
    private int solvex(long base, long exp, int mod) { //(Optimized than Using BigInteger)
        // return ((BigInteger.valueOf(2L)).modPow(BigInteger.valueOf((long)(max_depth-1)), BigInteger.valueOf(1000000009L))).intValue();
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int)res;
    }
        
    //h1--> DFS method by (Array of (ArrayList for connected nodes of particular node))
    private int h1(int edges[][]){
        ArrayList<Integer>[] idx=new ArrayList[edges.length+2];
        for(int i=1;i<=edges.length+1;i++) idx[i]=new ArrayList<>();
        for(int[] i:edges){
            idx[i[0]].add(i[1]);
            idx[i[1]].add(i[0]);
        }
        h11(idx,1,0,0);
        return solvex(2,max_depth-1,1000000007);
    }
    private void h11(ArrayList<Integer> idx[],int id,int depth,int par){
        for(int i:idx[id]){
            if(i!=par){
                h11(idx,i,depth+1,id);
            }
        }
        max_depth=Math.max(max_depth,depth);
    }

    //h2--> DFS method by (HashMap of (HashSet for connected nodes of particular node))- was giving TLE as for one iteration, there were so many operation like removing elements, new iterator, not continuos optimized iteration
    private int h2(int edges[][]){
        for(int i=0;i<edges.length;i++){
            idx.computeIfAbsent(edges[i][0], k -> new HashSet<>()).add(edges[i][1]);
            idx.computeIfAbsent(edges[i][1], k -> new HashSet<>()).add(edges[i][0]);
        }
        h12(idx,1,0);
        return solvex(2,max_depth-1,1000000007); //(Optimized than Using BigInteger)
    }
    private void h11(ArrayList<Integer> idx[],int id,int depth,int par){
        HashSet<Integer> cur=idx.get(id);
        if(cur==null){
            max_depth=Math.max(max_depth,depth);
            return;
        }
        while(!cur.isEmpty()){
            int c=cur.iterator().next();
            cur.remove(c);
            idx.get(c).remove(id); 
            h11(c,depth+1);
        }
    }
}
