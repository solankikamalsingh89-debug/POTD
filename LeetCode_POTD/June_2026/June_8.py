"""
Normal Question: Take element in order in another memory space

New Learning: Range(n) is evaluated once only, now even if you change value of n in loop, no impact
"""
class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]: #For less memory
        l=len(nums)
        i=0; j=l-1
        res=[None]*l
        for k in range(j+1):
            if nums[k]<pivot: 
                res[i]=nums[k]
                i+=1
            if nums[l-k-1]>pivot:
                res[j]=nums[l-k-1]
                j-=1
        while True: 
            res[i]=pivot
            if i==j: break;
            i+=1
        return res
    
    def pivotArray1(self, nums: List[int], pivot: int) -> List[int]: #For less time (Preferred)
        L1 = []
        L2 = []
        L3 = []
        for i in nums:
            if i<pivot:
                L1.append(i)
            elif i>pivot:
                L3.append(i)
            else:
                L2.append(i)
        return L1 + L2 + L3