package Leetcode_POTD.June_2026;

/*         TC       SC      Runtime
pairSum   O(n)     O(n)      10ms
pairSum1  O(n)     O(n)      7ms
pairSum2  O(n)     O(1)      4ms

Why pairSum2() is most optimized solution(Even after more traversal than other 2 solution)?
-Adding and getting in arraylist requires autoboxing and auto unboxing(Increase work for garbage collection and so runtime) 
-Defining arraylist size intially save time to resize arraylist and time in memory allocation
-Method: Tortoise and Hare Algorithm
    With 2 nodes as slow and fast(2x), traverse till fast!=null
    Now reverse inplace the rest halg linked list from slow pointer's next(maintiaing node as pre to make it's next)
    Now traverse both linked list simultaneously to get maximum twin's sum
*/

import java.util.ArrayList;

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
class June_14 {
    public int pairSum(ListNode head) { //My Code ( TC - O(n), SC - O(n) )
        ArrayList<Integer> a=new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
        int m=0;
        int l=a.size();
        for(int i=0;i<=l/2;i++){
            m=Math.max(m,a.get(i)+a.get(l-i-1));
        }
        return m;
    }
    public int pairSum1(ListNode head) { //My optimized code(without using Reversing linked list) ( TC - O(n), SC - O(n) )
        ArrayList<Integer> a=new ArrayList<>();
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            a.add(head.val);
            head=head.next;
            fast=fast.next.next;
        }
        int m=0;
        int l=a.size();
        for(int i=0;i<l;i++){
            m=Math.max(m,a.get(l-1-i)+head.val);
            head=head.next;
        }
        return m;
    }
    public int pairSum2(ListNode head) { //Optimized Code(Reverse half solution)  ( TC - O(n), SC - O(1) )
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode pre=null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre =curr;
            curr=next;
        }
        int max=0;
        int sum=0;
        ListNode p1=head;
        ListNode p2=pre;
        while(p2!=null){
            sum=p1.val+p2.val;
            p1=p1.next;
            p2=p2.next;
            if(max<sum){
                max=sum;
            }
        }
     return max;
    }
}