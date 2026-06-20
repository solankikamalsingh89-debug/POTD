"""
For case b=0--> retun 1
Checked that only 1,2 or 4 digits can appear for every digit coming in last of 'a'
So, maximium dvisibility to check by 2 and 4, so took last 2 digits of 'b' to check that
"""

class Solution:
    def getLastDigit(self, a, b):
        if b=='0': return 1
        a=(int)(a[-1])
        end=[a]
        i=a*a
        while i%10!=a:
            end.append(i%10)
            i*=a
        #1(1), 2(2,4,8,6), 3(3,9,7,1), 4(4,6), 5(5), 6(6), 7(7,9,3,1), 8(8,4,2,6), 9(9,1)
        #1,5,6 (same), 4,9(2), 2,3,7,8(4)
        return end[(int)(b[-2:])%len(end)-1]  