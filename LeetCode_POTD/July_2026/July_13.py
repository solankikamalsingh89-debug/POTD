"""
To avoid check for lower limit at each iteration, make the lowest required number(not considering high limit for now), then iterate until high limit
How we iterate: By keeping first digit fix and number of digits, then each time increement first digit (if last digit exceed 9- not possible, start from length+1 and intitial digit 1)

TC - O(log10(n)), SC - O(1)
"""

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        ans=[]
        n=(int)(math.log10(low))
        i=low//(10**n)
        if n+i>9:
            n+=1
            if n>=9: return ans 
            i=1
        num=0
        for k in range(n+1):
            num=num*10+i+k
        if num<low:
            i+=1
            if n+i>9:
                n+=1
                if n>=9: return ans
                i=1
            num=0
            for k in range(n+1):
                num=num*10+i+k
        while n<9 and num<=high:
            ans.append(num)
            i+=1
            if n+i>9:
                n+=1
                if n>=9: return ans 
                i=1
            num=0
            for k in range(n+1):
                num=num*10+i+k
        return ans