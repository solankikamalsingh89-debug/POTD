package Leetcode_POTD.June_2026;
/*
Precompute with O(nlogn) for finding min and max in any range of array
Store with PriorityQueue to store in descending order of value to extract till k>0(needed cases), each time decresing the length of subarray(starting with complete array)
TC - O(nlogn + klogn), SC - O(nlogn)

New Learning: SparseTable(Static Array, multiple cases to get max or min in different subarrays)
i)PreComputation( O(nlogn) )
    Let's assume dots(.) as elements of array      (Let's say 9 elements)
    . . . . . . . . .            (Level 0 - (i)th element represents subarray's max starting from (i)th idx in array of length 1)
    . . . . . . . .              (Level 1 - (i)th element represents subarray's max starting from (i)th idx in array of length 2)
    . . . . . .                  (Level 2 - (i)th element represents subarray's max starting from (i)th idx in array of length 4)
    . .                          (Level 3 - (i)th element represents subarray's max starting from (i)th idx in array of length 8)
    (You migh think: How it then decreased size with base 2 and not 1(As the elements choosen to find max on next level are such that they don't overlap and summing up gives maximum in twice size subarray))
    (i.e. why only array till (int)log2(size of array))-->(sparseMax[j][i] = Math.max(sparseMax[j - 1][i], sparseMax[j - 1][i + (1 << (j - 1)) , where j=level)
    Similarly for SparseMin array computing
    (e.g. arr={2,4,5,1}
          SparseMax={
            {2,4,5,1,9,6},
            {4,5,5,9,6},
            {5,9,9}
          }
    )

ii)Query( O(1) )
    Let's say for idx(2 to 4) 
    Get l=3(length of subarray)(Now we will act according to it starting from 2 and log2(3)=1)

    As each time we will not encounter base 2 length of subarray, so we will overlap some element from starting(2) and startingInRevers(4) to find maximum((2,3),(3,4))
    Incase if it's length is base 2, then they won't overlap

    -->( Math.max(sparseMax[j][L], sparseMax[j][R - (1 << j) + 1]), where j=level=log2(End-Start+1) )
    Similarly to get min in range
*/

import java.util.PriorityQueue;
import org.w3c.dom.Node;

public class June_10 {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        int[] logs = new int[n + 1];
        for (int i = 2; i <= n; ++i) logs[i] = logs[i >> 1] + 1;
        int maxLog = logs[n];

        int[][] sparseMax = new int[maxLog + 1][n];
        int[][] sparseMin = new int[maxLog + 1][n];
        for (int i = 0; i < n; ++i) {
            sparseMax[0][i] = nums[i];
            sparseMin[0][i] = nums[i];
        }
        for (int j = 1; j <= maxLog; ++j) {
            int span = 1 << j;
            int half = 1 << (j - 1);
            for (int i = 0; i + span <= n; ++i) {
                sparseMax[j][i] = Math.max(sparseMax[j - 1][i], sparseMax[j - 1][i + half]);
                sparseMin[j][i] = Math.min(sparseMin[j - 1][i], sparseMin[j - 1][i + half]);
            }
        }

        class RMQ {
            int maxQuery(int L, int R) {
                int len = R - L + 1;
                int j = logs[len];
                return Math.max(sparseMax[j][L], sparseMax[j][R - (1 << j) + 1]);
            }
            int minQuery(int L, int R) {
                int len = R - L + 1;
                int j = logs[len];
                return Math.min(sparseMin[j][L], sparseMin[j][R - (1 << j) + 1]);
            }
            long rangeValue(int L, int R) {
                return (long) maxQuery(L, R) - (long) minQuery(L, R);
            }
        }
        final RMQ rmq = new RMQ();

        class Node {
            long value;
            int left, right;
            Node(long v, int l, int r) { value = v; left = l; right = r; }
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));
        for (int l = 0; l < n; ++l) {
            heap.offer(new Node(rmq.rangeValue(l, n - 1), l, n - 1));
        }

        long total = 0L;
        int count = 0;
        while (count < k && !heap.isEmpty()) {
            Node cur = heap.poll();
            total += cur.value;
            count++;
            if (cur.right - 1 >= cur.left) {
                int nr = cur.right - 1;
                heap.offer(new Node(rmq.rangeValue(cur.left, nr), cur.left, nr));
            }
        }
        return total;
    }
}
