package Leetcode_POTD.July_2026;

/*
Just do as prescribed in question.

TC - O(nlogn), SC - O(n)
*/

import java.util.Arrays;

public class July_16 {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int prefixGCD[]=new int[n];
        int m=nums[0];
        for(int i=0;i<n;i++){
            if(m<=nums[i]) prefixGCD[i]=m=nums[i];
            else prefixGCD[i]=gcd(nums[i],m);
        }
        Arrays.sort(prefixGCD);
        long ans=0;
        for(int i=0;i<n/2;i++){
            ans+=gcd(prefixGCD[n-i-1],prefixGCD[i]);
        }
        return ans;
    }
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
