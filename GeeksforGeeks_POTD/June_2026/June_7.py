"""
Irrespective of level, that position if exist are same profession(As seen from pattern- in half it repeats previous level output as input are same)
So, we'll work with position only:
    We declare (l = Elements in no. of prior level to minimum level for given pos)
    (Why taken 1 prior level- To check whether lies in first half or second half)-->If first half remains same, else profession change (maintained by ans) 
    As pos=1 bit_length=1, so we took previously checked itself
TC - O(log2(pos)), SC - O(1)

"""
class Solution:
    def profession(self, level, pos):
        if pos==1:
            return "Engineer"
        ans=True #Engineer
        l=2**((pos - 1).bit_length())
        while l>0:
            if pos>l:
                ans=not ans 
                pos-=l
            l/=2
        if ans:
            return "Engineer"
        else:
            return "Doctor"