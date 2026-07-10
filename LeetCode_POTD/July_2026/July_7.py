"""
Easy - do as stated

TC - O(log10(n)), SC - O(1)
"""

class Solution:
    def sumAndMultiply(self, n: int) -> int:
        if n == 0:
            return 0
        s = str(n)
        sum_non_zero = 0
        res = ""
        for c in s:
            if c != "0":
                res += c
                sum_non_zero += int(c)
        return sum_non_zero * int(res)