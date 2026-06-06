"""
Total ways to sit 2 knight without any restriction on 2 different places = n*m*(n*m-1)
Restricted cases = From every postion of 1 knight fixed either we have 4 places (2Vert & 1Hor.) or (1Vert. & 2Hor.) i.e. 2 terms added
                    (But for corner lines we have only 2-2 places , so take 2 corners=1 set)--> (m-1) and (n-1)
                    Now this factor is multiplied with (n-2) and (m-2) respectively with Math.max to maintain +ve for cases n==1 or m==1
                    (-2 is done as for 2 steps requires)
"""
class Solution:
    def numOfWays(self, n: int, m: int) -> int:
        return (n*m)*((n*m)-1)-4*(max(0,(m-1)*(n-2))+max(0,(n-1)*(m-2)))