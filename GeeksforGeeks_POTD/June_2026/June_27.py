"""
Either a complete stack of n tiled will be horizontal or these will get erected at the same time, following this find for all possible ways(How much tiles horizontal and remaining vertical)
Then, (H-horizontal, V-vertical) --> Think as no. of words we can make by HHV, ..... (whatever patter comes) - with optimized nCr

TC - O(n), SC - O(n)
"""

class Solution:
	def countWays(self, n, m):
		MOD=1000000007
        l=n
        if m>n: return 1
        if m==n: return 2
        fact = [0]*(l+1)
        invFact=[0]*(l + 1)
        fact[0] = 1
        for i in range(1,l+1):
            fact[i] = (fact[i - 1] * i) % MOD
        invFact[l] = self.power(fact[l], MOD - 2, MOD)
        for i in range(l - 1,-1,-1):
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD
        
        ans=0
        d=n//m
        r=n%m
        while d>=0:
            ans=(ans+fact[r+d]*invFact[r]*invFact[d])%MOD
            d-=1
            r+=m
        return ans
    def power(self, base, exp, mod):
        res = 1
        base %= mod
        while exp > 0:
            if (exp & 1) == 1:
                res = (res * base) % mod
            base = (base * base) % mod
            exp >>= 1
        return res