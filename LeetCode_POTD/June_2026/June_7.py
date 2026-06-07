"""
Dictionary(map) for val, and its node refernce -> If node is node created- create it and assign respective child of them in each descriptions--> Maintaining Tree
Also Set for children: Root can't be a children- so used this to get root Node in end
TC - O(n), SC - O(n)

"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        node={}
        children=set()
        for parent,child,isleft in descriptions:
            if parent not in node:
                node[parent]=TreeNode(parent)
            if child not in node:
                node[child]=TreeNode(child)
            if isleft:
                node[parent].left=node[child]
            else:
                node[parent].right=node[child]
            children.add(child)
        for val in node:
            if val not in children:
                return node[val]
        