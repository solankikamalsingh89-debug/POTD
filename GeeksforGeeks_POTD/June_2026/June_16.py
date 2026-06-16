"""
Traversed in reverse in queries so that maintain overall xor needed to do on element added previously in query (Later if back traversed)(At end don't forget query(0,0))
(Doing front traversal gave TLE)

TC - O(qlogq){Sorting}, SC - O(1)
"""

class Solution:
    def constructList(self, queries):
        xor=0
        a=[]
        for i in range(len(queries)-1,-1,-1):
            if queries[i][0]==0:
                a.append(queries[i][1]^xor)
            else:
                xor^=queries[i][1]
        a.append(xor)
        a.sort()
        return a