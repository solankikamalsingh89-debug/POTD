package Leetcode_POTD.June_2026;
/*
No explaination needed(Easy)
*/
public class June_9 {
    public long maxTotalValue(int[] nums, int k) {
        int min=Integer.MAX_VALUE,  max=0;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return (long)k*(max-min);`
    }
}
