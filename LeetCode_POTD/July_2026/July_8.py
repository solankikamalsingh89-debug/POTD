"""
For sum we precomputef prefix sum so that sum can be calculate O(1) per query
And one array/list is maintained for how many non-zero element has occured so that for getting number after MOD as -> Number(r)-Number(l)*(10^(number of digits appeared after it))

TC - O(n+m), SC - O(n+m)
"""

class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7
        n = len(s)
        powers = [1] * (n + 1)
        for i in range(1, n + 1):
            powers[i] = (powers[i-1] * 10) % MOD
            
        np = [0] * (n + 1) 
        sp = [0] * (n + 1)
        cp = [0] * (n + 1)
        
        cn = 0
        cs = 0
        cc = 0
        
        for i, char in enumerate(s):
            digit = int(char)
            if digit != 0:
                cn = (cn * 10 + digit) % MOD
                cs += digit
                cc += 1
            np[i+1] = cn
            sp[i+1] = cs
            cp[i+1] = cc
            
        ans = []
        
        for l, r in queries:
            cz = cp[r+1] - cp[l]
            
            if cz == 0:
                ans.append(0)
                continue
            ds = sp[r+1] - sp[l]
            
            fv = np[r+1]
            pv = np[l]
            shifted_prev = (pv * powers[cz]) % MOD
            
            x = (fv - shifted_prev) % MOD
            res = (x * ds) % MOD
            ans.append(res)
            
        return ans
        