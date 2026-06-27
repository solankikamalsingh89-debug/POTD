package GeeksforGeeks_POTD.June_2026;

/*
Either a complete stack of n tiled will be horizontal or these will get erected at the same time, following this find for all possible ways(How much tiles horizontal and remaining vertical)
Then, (H-horizontal, V-vertical) --> Think as no. of words we can make by HHV, ..... (whatever patter comes) - with optimized nCr

TC - O(n), SC - O(n)
*/

public June_27 {
    public int countWays(int n, int m) {
        int MOD=1_000_000_007;
        int l=Math.max(n,m);
        long[] fact = new long[l + 1];
        long[] invFact = new long[l + 1];
        fact[0] = 1;
        for (int i = 1; i <= l; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[l] = power(fact[l], MOD - 2, MOD);
        for (int i = l - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
        
        long ans=0L;
        int d=n/m;
        int r=n%m;
        while(d>=0){
            ans=(ans+fact[r+d]*((invFact[r]*invFact[d])%MOD))%MOD;
            d--;
            r+=m;
        }
        return (int)ans;
    }
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}