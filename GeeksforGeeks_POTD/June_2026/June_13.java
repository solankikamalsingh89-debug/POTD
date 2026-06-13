package GeeksforGeeks_POTD.June_2026;
/*
We have to calculate ((nC0)^2+(nC1)^2+.....+(nCn)^2) = 2*((nC0)^2+(nC1)^2+.....+(nC((n-1)/2))^2)+(if n==even, (nC(n/2))^2)
As need is to do calculation within MOD condition and datatypes limit.
Also as various time nCr is called, so precomputation

Simply define fact[] with factorial of number(idx)%MOD
For division, we will get invFact[] similarly as: (Fermat's Little Theorem: The theorem states that if p is a prime number, and a is any integer that is not divisible by p then: ((a^(p-1) is equivalent to 1) mod p)
    invFact[n] = power(fact[n], MOD - 2, MOD);
    for (int i = n - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD; //As 1/(i-1)! = i/i!
*/
public class June_13 {
    private static final int MOD = 1_000_000_007;
    public int computeValue(int n) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ans = 2;
        for (int i = 1; i < (n + 1) / 2; i++) {
            long nCr = fact[n];
            nCr = (nCr * invFact[i]) % MOD;
            nCr = (nCr * invFact[n - i]) % MOD;
            long sq = (nCr * nCr) % MOD;
            ans = (ans + 2 * sq) % MOD;
        }
        if (n % 2 == 0) {
            long nCr = fact[n];
            nCr = (nCr * invFact[n / 2]) % MOD;
            nCr = (nCr * invFact[n / 2]) % MOD;
            ans = (ans + (nCr * nCr) % MOD) % MOD;
        }
        return (int) ans;
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
