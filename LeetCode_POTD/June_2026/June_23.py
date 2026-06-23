"""
With few examples, i found pattern and reason to pattern as:
e.g (r-l=5), then let's think first 5 numbers and notice pattern on length given n
 
Inc(k) means reached at 'k'(no.) as increasing
(When n=1, there are 'r-l+1' paths(starting with 1,2...(r-l+1) ))
n       2   3   4 ....
Inc2    1   4   10
Inc3    2   7   19
Inc4    3   9   26
Inc5    4   10  30
Dec1    4   10  30
Dec2    3   9   26
Dec3    2   7   19
Dec4    1   4   10

So, we can it's happening/increasing in a way previous array elemnts getting added to new
So we will maintain array of number of Inc and Dec (1 to (r-l+1)) and when reach the required 'n' sum element of array and double it to cover symmetry
(Also at each step we have to keep check on MOD)

TC - O(n*(r-l)), SC - O(r-l)

"""

class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD=1000000007
        h1=[None]*(r-l)
        for i in range(r-l): h1[i]=r-l-i
        for i in range(n-2):
            if i%2==0:
                for j in range(r-l-1):
                    h1[j+1]=(h1[j]+h1[j+1])%MOD
            else:
                for j in range(r-l-2,-1,-1):
                    h1[j]=(h1[j]+h1[j+1])%MOD
        sum=0
        for j in range(r-l): sum=(sum+2*h1[j])%MOD
        return sum