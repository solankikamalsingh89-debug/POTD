"""
We have to calculate ((nC0)^2+(nC1)^2+.....+(nCn)^2) = 2*((nC0)^2+(nC1)^2+.....+(nC((n-1)/2))^2)+(if n==even, (nC(n/2))^2)
As need is to do calculation within MOD condition and datatypes limit.
Also as various time nCr is called, so precomputation

Simply define fact[] with factorial of number(idx)%MOD
For division, we will get invFact[] similarly as: (Fermat's Little Theorem: The theorem states that if p is a prime number, and a is any integer that is not divisible by p then: ((a^(p-1) is equivalent to 1) mod p)
    invFact[n] = power(fact[n], MOD - 2, MOD);
    for (int i = n - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD; //As 1/(i-1)! = i/i!
"""

class Solution:
    def computeValue(self, n):
        MOD=1000000007
        fact=1
        invFact=[1]*(n+1)
        for i in range(2,n+1):
            fact=(fact*i)%MOD
        invFact[n]=pow(fact,MOD-2,MOD)
        for i in range(n-1,-1,-1):
            invFact[i]=(invFact[i+1]*(i+1))%MOD
        
        ans=2
        for i in range(1,(n+1)//2):
            ans+=((2*((((fact*invFact[i])%MOD)*invFact[n-i])%MOD)**2))%MOD
            ans%=MOD
        if n%2==0:
            ans+=(((((fact*invFact[n//2])%MOD)*invFact[n//2])%MOD)**2)%MOD
            ans%=MOD
        return ans