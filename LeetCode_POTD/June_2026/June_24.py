import numpy as np

"""
In th previous version, 'n' was small, so n*(r-l) was not exceeding time limit.
This time it's multiplication is going out for time limit.

# n is (n-1) here ()
So, adding up things (r-l things) n-times is replaced by n-times matrix multiplication
We're making matrix B equals n-times multiplication of matrix( All diagonal elements and upper half element are 1 ) - Let's say matrix C
Now how we will reover time limit here-- By multiplying it maximum log2(n) times only (As matrix can be multiplied according to bits of n) as:
    Use power so that iterationd could be decreased while multiplying (C^4=C*C*C*C=(C^2)^2)

TC - O( log2(n)*(r-l) ), SC - O( (r-l)^2 )
"""

class Solution:
    #Solution 1 (Using numpy array matrix multiplication)--more optimized
    def zigZagArrays1(self, n: int, l: int, r: int) -> int:
        MOD = 1_000_000_007
        k = r - l + 1
        m = np.array([[int(i + j + 1 < k) for j in range(k)] for i in range(k)], dtype=object)
        res = np.ones((1, k), dtype=object)
        n -= 1
        while n:
            if n & 1:
                res = (res @ m) % MOD
            m = (m @ m) % MOD
            n >>= 1
        return int(res.sum() * 2 % MOD)

    #Solution 2
    MOD=1000000007
    def zigZagArrays2(self, n: int, l: int, r: int) -> int:
        res=[[1 if i==j else 0 for j in range(r-l)] for i in range(r-l)]
        c=[[1 if j+i>=r-l-1 else 0 for j in range(r-l)] for i in range(r-l)]
        n-=1
        while n>0:
            if n&1:
                res=self.zigZagArrays21(res,c,r-l)
            c=self.zigZagArrays21(c,c,r-l)
            n>>=1
        return (sum([sum(res[i]) for i in range(r-l)])*2)%self.MOD
    def zigZagArrays21(self, a, b, s):
        c=[[0 for _ in range(s)] for _ in range(s)]
        for i in range(s):
            for j in range(s):
                for k in range(s):
                    c[i][j]=(c[i][j]+a[i][k]*b[k][j])%self.MOD
        return c