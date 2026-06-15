package Leetcode_POTD.June_2026;

/*
Traverse to middle by fast ad slow pointers
Seeing the case to delete middle: Maintain a prev node for just before middle and make its next = middle's next
(One better way without any previous node maintainace--> ListNode slow=new ListNode(-1); slow.next=head;)

TC - O(n), SC - O(1)
*/

public class June_15 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode prev,fast,slow;
        fast=slow=head;
        prev=null;
        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
}
