package Leetcode_POTD.July_2026;


/*
    We'll be having gcd always lesser than equal to minimum of both values.- so create dyanamic programming array with maximum element size
    dp[i][j][k]=denotes number of ways seq1 with hcf (j), seq2 with hcf (k) within first i elements
    Now iterate each element and update till i-th length by (i-1) and current element gcd - either choosing for seq1 or seq2 or for none
    Then finally at length (complete iteration), get sum of all such cases with equal gcd

    TC - O(n*(max_elemet)^2), SC - O((max_elemet)^2)
*/ 

public class July_14 {
    public int subsequencePairCount(int[] nums) {
        int MOD=1_000_000_007;
        int m=0;
        for(int i:nums) m=Math.max(m,i); 
        long[][] dp=new long[m+1][m+1];
        dp[0][0]=1;
        for(int i:nums){
            long ndp[][]=new long[m+1][m+1];
            for(int j=0;j<=m;j++){
                int d1=gcd(j,i);
                for(int k=0;k<=m;k++){
                    if(dp[j][k]==0) continue;
                    int d2=gcd(k,i);
                    ndp[j][k]=(dp[j][k]+ndp[j][k])%MOD;
                    ndp[d1][k]=(dp[j][k]+ndp[d1][k])%MOD;
                    ndp[j][d2]=(ndp[j][d2]+dp[j][k])%MOD;
                }
            }
            dp=ndp;
        }
        int ans=0;
        for(int j=1;j<=m;j++) ans=(int)((ans+dp[j][j])%MOD);
        return ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
