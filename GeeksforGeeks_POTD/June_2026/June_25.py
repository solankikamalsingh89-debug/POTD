"""
Clearly if n is 1 then  only we can use 0, else not(As 0 can be used in staarting only-- which will interrupt to make it n-digit number)--> so, define it's result sepeartely
So, if n greater than 9 -> Can't make number(as only 9 digits to use)
For rest cases: ( n = 2 to 9 )
    Using helper function keep a number maker each time adding a last digit in it(which is strictly increasing) with recursion

TC - O(n^2), SC - O(n){ Recursion stack }
"""

class Solution:
    def increasingNumbers(self, n):
        if n>9: return []
        if n==1: return [0,1,2,3,4,5,6,7,8,9]
        ans=[]
        self.increasingNumbers1(0, 0, n, ans)
        return ans
    def increasingNumbers1(self, a, l, n, ans):
        if l==n:
            ans.append(a)
            return True
        if a%10>=9: return False
        for i in range(a%10+1,10):
            if not self.increasingNumbers1(a*10+i, l+1, n, ans): return True
        return True
