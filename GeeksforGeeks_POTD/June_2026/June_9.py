"""
We keep condition with prev element to be empty or no restriction
From index 0, we checked for empty with next to be 0(empty), then seat one person. -> Then one idx is skipped
If idx is occupied, check if next is also occupied-> false else sikp next idx
At the end check for last idx if also can be seated
Then check condition for at least k get seated
TC - O(n), SC - O(1)
"""

class Solution:
    def canSeatAllPeople(self, k, seats):
        if len(seats)==1:
            if seats[0]==1: 
                if k==0: return True
                else: return False
            elif k<=1:
                return True
            else:
                return False
        if seats[0]==0 and seats[1]==0: 
            k-=1
            seats[0]=1
        for i in range(1,len(seats)-1,1):
            if seats[i]==0:
                if seats[i-1]==0 and seats[i+1]==0:
                    k-=1
                    seats[i]=1
            else:
                if seats[i-1]==1 or seats[i+1]==1:
                    return False
        if seats[len(seats)-2]==seats[len(seats)-1]:
            if seats[len(seats)-2]==0: k-=1
            else: return False
        if k<1: return True
        return False