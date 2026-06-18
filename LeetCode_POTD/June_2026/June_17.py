"""
Firstly check the final length of result. 
-If length <= k --> return '.' (As k is 0-indexed)
-Else
    Traverse string in reverse (undoing operation)-- maintain the length of result after undoing each operation
    for alphabet --> As answer will be any of added alphabet for sure, so check when undoing this operation if k+1==length (As k is 0-indexed), otherwise length--
    for * --> Add 1 i length
    for # --> Length will be halved, but if doing this length becomes <= k, means k is included in repeated string (so substract k by (length/2) as well)
    for % --> Make k reaching from back (k=l-k-1)
"""

class Solution:
    def processStr(self, s: str, k: int) -> str:
        l=0
        for i in s:
            if i=='*':
                if l>0: l-=1
            elif i=='#': l*=2
            elif i=='%': continue
            else: l+=1
        if l<=k: return '.'
        for i in reversed(s):
            if i=='*': l+=1
            elif i=='#': 
                if l//2<=k: k-=l//2
                l//=2
            elif i=='%': k=l-k-1
            else:
                if l==k+1: return i
                l-=1
        return '.'