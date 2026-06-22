"""
Easy
TC - O(n), SC - O(1)
"""

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        return min(text.count('l')//2,text.count('o')//2,text.count('a'),text.count('b'),text.count('n'))