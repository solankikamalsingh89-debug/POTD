package Leetcode_POTD.July_2026;

/*
For sum we precomputef prefix sum so that sum can be calculate O(1) per query
And one array/list is maintained for how many non-zero element has occured so that for getting number after MOD as -> Number(r)-Number(l)*(10^(number of digits appeared after it))

TC - O(n+m), SC - O(n)
*/

public class July_8 {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int MOD = 1_000_000_007;
        long[] sb = new long[n + 1];
        int[] pre = new int[n + 1];
        int[] sbi = new int[n + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            pre[i + 1] = pre[i] + c;
            if (c > 0) {
                sb[i + 1] = (sb[i] * 10 + c) % MOD;
                sbi[i + 1] = ++j;
            } else {
                sb[i + 1] = sb[i];
                sbi[i + 1] = sbi[i];
            }
        }
        long[] pow10 = new long[j + 1];
        pow10[0] = 1;
        for (int i = 1; i <= j; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int len = sbi[r] - sbi[l];
            long val = (sb[r] - (sb[l] * pow10[len]) % MOD + MOD) % MOD;
            ans[i] = (int) (val * (pre[r] - pre[l]) % MOD);
        }
        return ans;
    }
}
