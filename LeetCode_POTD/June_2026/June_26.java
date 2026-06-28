package Leetcode_POTD.June_2026;

/*
Treating target as 1 and all others as -1.
Find the prefix sum array according to it and find ways so that sum is greater than 0. --> It will lead to O(n^2){Sum -n to n}
So, we will mark number of times that lesser than idx, prefix sum came till iterated and increase the result accordingly.{prefix[r]>prefix[l] for (l to r) to be counted }
freq -> thought as represents sum --> -n, -n+1, ... 0 ... n-1, n  and pref represents freq of all less than x occuring

TC - O(n), SC - O(n)
*/

public class June_26 {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int [] freq=new int[2*n+1];
        freq[n]=1;
        int idx=n;
        long res=0;
        long pref=0;
        for(int x:nums){
            if(x==target){
                pref+=freq[idx];
                idx++;
            }
            else{
                idx--;
                pref-=freq[idx];
            }
            freq[idx]++;
            res+=pref;
        }
        return res;
    }
}
