"""
Traverse to middle by fast ad slow pointers
Seeing the case to delete middle: Maintain a prev node for just before middle and make its next = middle's next
(One better way without any previous node maintainace--> slow=new ListNode(-1,head) )

TC - O(n), SC - O(1)
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return None
        slow = head
        fast = head
        prev = None
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        prev.next = slow.next
        return head
            