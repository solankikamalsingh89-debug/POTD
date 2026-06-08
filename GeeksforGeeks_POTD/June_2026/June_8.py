"""
(In first attempt i used list.pop(0) for traversing list from front- which gave TLE (WHY? -> As pop shifts all elements so take O(n)))
Convert node's data sequence in LinkedList into List.
Traverse it back to know which to delete(By maintaining max)(To delete = -1)
Traverse Linkedlist first till we got head fixed(First not to delete node)
Traverse further to delete node(By attaching (previous not deleted node) to (next not to delete))
finally make last node's next = null to end LinkedList
"""

'''
Structure of linked list node
class Node:
    def __init__(self,x):
        self.data=x
        self.next=None

'''
class Solution:
    def compute(self,head):
        list=[]
        node=head
        while node is not None:
            list.append(node.data)
            node=node.next
        max=0
        for i in range(len(list)-1,-1,-1):
            if max<=list[i]:
                max=list[i]
            else:
                list[i]=-1
        
        i=0
        while True:
            if list[i]!=-1:
                break;
            head=head.next
            i+=1
        i+=1
        node=head.next
        prev=head
        while node!=None:
            if list[i]!=-1:
                prev.next=node
                prev=node
            node=node.next
            i+=1
        prev.next=None
        return head