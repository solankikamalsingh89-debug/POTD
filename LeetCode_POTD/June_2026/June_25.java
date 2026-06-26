package Leetcode_POTD.June_2026;

/*
Just simply by Brute Force
*/

public class June_25 {
    public int countMajoritySubarrays1(int[] nums, int target) { //Brute force( O(n^2) )
        int l=nums.length;
        int ans=0;
        for(int i=0;i<l;i++){
            int c=0;
            for(int j=i;j<l;j++){
                if(nums[j]==target) c++;
                if(c*2>j-i+1) ans++;
            }
        }
        return ans;
    }
}
