"""
total0=(All 0's * 4(as 4 direction) i.e. Coverage)
Firstly loop horizontally to count total0 with keeping track of horizontal 0 not to be counted (Remeber case: 0 in all columns(Don't count twice))
Then loop vertically to substrract not in coverage 0(Similarly here also remember same case to not substract twice)
"""

class Solution:
    def findCoverage(self, mat):
        total0=0
        for i in mat:
            j=0
            while j<len(i):
                if i[j]==1: break
                j+=1
            if j==len(i):
                total0+=2*j 
                continue
            total0+=3*j
            cnt0=0;
            while j<len(i):
                if i[j]==0:
                    cnt0+=1
                else:
                    total0+=4*cnt0
                    cnt0=0
                j+=1
            total0+=3*cnt0
        for i in range(len(mat[0])):
            j=0
            while j<len(mat):
                if mat[j][i]==0: total0-=1
                else:
                    j=len(mat)-1
                    while mat[j][i]==0:
                        total0-=1
                        j-=1
                    break
                j+=1
            if j==len(mat): total0-=j
        return total0