package GeeksforGeeks_POTD.July_2026;

/*
Use priority queue too get maximum element each time either untill tickets exhaust or limit of k exceed

TC - O(n+klogn), SC - O(n)
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class July_12 {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr) minHeap.offer(i);
        long amt=0;
        while(k>0 && !minHeap.isEmpty()){
            int a=minHeap.poll();
            amt=(amt+a)%1000000007;
            if(a>1) minHeap.offer(a-1);
            k--;
        }
        return (int)amt;
    }
}
