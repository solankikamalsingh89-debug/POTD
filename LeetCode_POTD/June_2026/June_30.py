"""
Method 1: (JAVA Code)
    Used two pointer:
        If number of char used are 3 increase previous(i) pointer
        Else substract from total (No. of non-empty subarray in between i and j)

    TC - O(n), SC - O(1)
Method 2: (PYTHON Code)
    Starting last indices with -1, count number of subarrays till iterated length containing all 3 char

    TC - O(n), SC - O(1)
"""

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        a, b, c = -1, -1, -1
        ans = 0
        for i, x in enumerate(s):
            if x == 'a':
                a = i
            elif x == 'b':
                b = i
            elif x == 'c':
                c = i
            if min(a, b, c) >= 0:
                ans += min(a, b, c) + 1
        return ans