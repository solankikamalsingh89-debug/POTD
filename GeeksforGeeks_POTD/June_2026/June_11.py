"""
Just count either closing bracket and then print count(as for each iteration (no. of (- no. of ) )will dec no matter which bracket is this)
Or count opening bracket and print (n-count) as this time traversal will be made from back to compare
"""
class Solution:
    def findIndex(self, s):
        c=0
        for i in s:
            if i==')':c+=1
        return c