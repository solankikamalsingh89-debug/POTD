"""
Started with (0,0) in right direction
Two functions defined(r-right(with 2 direction), u-upper(with 2 direction)) with each step traversal and handling 1

TC - O(n^2), SC - O(1)
"""

class Solution:
    def exitPoint(self, mat):
        return self.r(0,0,mat,True)
    def r(self,i,j,mat,dir):
        if dir:
            while j<len(mat[0]):
                if mat[i][j]==1:
                    mat[i][j]=0
                    return self.u(i+1,j,mat,False)
                j+=1
            return [i,len(mat[0])-1]
        else:
            while j>=0:
                if mat[i][j]==1:
                    mat[i][j]=0
                    return self.u(i-1,j,mat,True)
                j-=1
            return [i,0]
    def u(self,i,j,mat,dir):
        if not dir:
            while i<len(mat):
                if mat[i][j]==1:
                    mat[i][j]=0
                    return self.r(i,j-1,mat,False)
                i+=1
            return [len(mat)-1,j]
        else:
            while i>=0:
                if mat[i][j]==1:
                    mat[i][j]=0
                    return self.r(i,j+1,mat,True)
                i-=1
            return [0,j]