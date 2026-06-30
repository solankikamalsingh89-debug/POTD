package GeeksforGeeks_POTD.June_2026;

/*
For edge cases like k>=n, not possible and k==n-1 means only 1 possible solution with all 1.
So, for lower cases:
    dp[i][j][0] represents choosing this node as 0, number of ways exist for length 'i' with 'j' adjacent 1 pairs
    So, intitalize with length 1 having 1-1 cases for both 0 and 1 with 0 adjacent pairs
    Then iterate over full dp -> 
        Initialize for both 0 and 1 with length 'i'
        And add according to previous cases 

TC - O(n*m), SC - O(n*m)

However, SC can be done O(m) as only 1 previous cell 'i-1' is required to update complete 'j' of i (PYTHON Code)
*/

public class June_28 {
    public int countStrings(int n, int k) {
        if(k>=n) return 0;
        if(k==n-1) return 1;
        long dp[][][]=new long[n+1][k+1][2]; 
        dp[1][0][1]=dp[1][0][0]=1;
        for(int i=2;i<=n;i++){
            dp[i][0][0]=(dp[i-1][0][0]+dp[i-1][0][1])%1_000_000_007;
            dp[i][0][1]=dp[i-1][0][0];
            for(int j=0;j<i-1 && j<k;j++){
                dp[i][j+1][1]=(dp[i-1][j][1]+dp[i-1][j+1][0])%1_000_000_007;
                dp[i][j+1][0]=(dp[i-1][j+1][1]+dp[i-1][j+1][0])%1_000_000_007;
            }
        }
        return (int)((dp[n][k][0]+dp[n][k][1])%1_000_000_007);
    }
}
