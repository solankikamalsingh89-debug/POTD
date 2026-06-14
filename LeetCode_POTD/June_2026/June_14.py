"""
Line 23: (Here using this way optimized the code's runtime (not using temp varibale and updating everything individually)- as it uses tuple assignment in C)
Line 28: (Instead of using max(m,val), we checked by for loop as it is faster in python)
Method: Tortoise and Hare Algorithm
    With 2 nodes as slow and fast(2x), traverse till fast!=null
    Now reverse inplace the rest halg linked list from slow pointer's next(maintiaing node as pre to make it's next)
    Now traverse both linked list simultaneously to get maximum twin's sum
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow=fast=head
        while fast is not None:
            slow=slow.next
            fast=fast.next.next
        prev=None
        while slow:
            slow.next,prev,slow=prev,slow,slow.next
        slow=prev
        m=0
        while slow is not None:
            total=slow.val+head.val
            if m<total: m=total
            head,slow=head.next,slow.next
        return m