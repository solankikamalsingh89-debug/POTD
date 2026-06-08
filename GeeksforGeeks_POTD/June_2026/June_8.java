package GeeksforGeeks_POTD.June_2026;
/*
Convert node's data sequence in LinkedList into ArrayList.
Traverse it back to know which to delete(By maintaining max)(To delete = -1)
Traverse Linkedlist first till we got head fixed(First not to delete node)
Traverse further to delete node(By attaching (previous not deleted) node t0 (next not to delete))
finally make last node's next = null to end LinkedList
*/
import java.util.ArrayList;
import org.w3c.dom.Node;

public class June_8 {
    /* Structure of linked list node
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    */

    Node compute(Node head) {
        Node node=head;
        ArrayList<Integer> a=new ArrayList<>();
        while(node!=null){
            a.add(node.data);
            node=node.next;
        }
        int max=0;
        for(int i=a.size()-1;i>=0;i--){
            if(max<=a.get(i)) max=a.get(i);
            else a.set(i,-1);
        }
        int i=0;
        for(;i<a.size();i++){
            if(a.get(i)==-1) head=head.next;
            else break;
        }
        i++;
        Node prev=head;
        node=head.next;
        for(;i<a.size();i++){
            if(a.get(i)!=-1){
                prev.next=node;
                prev=node;
            }
            node=node.next;
        }
        prev.next=null;
        return head;
    }
}
