package Leetcode_POTD.June_2026;

/*
New Method: Counting Sort(For all numbers as index of another array, store frequenccy for them)

Applied Counting Sort, then handle coins left to know how much can we buy from lowest to going higher indices.
(However, we could do it by making array with max value- by adding one traversal in array first to get maximum value)

TC - O(10^5+n)=O(1), SC - O(10^5)=O(1)
*/

public class June_21 {
    public int maxIceCream(int[] costs, int coins) {
        int[] a=new int[100001];
        int l=0;
        for(int i:costs){
            a[i]++;
        }
        for(int i=1;i<100001;i++){
            coins-=(i*a[i]);
            if (coins>=0) l+=a[i];
            else {
                l+=(coins+(i*a[i]))/i;
                break;
            }
        }
        return l;
    }
}