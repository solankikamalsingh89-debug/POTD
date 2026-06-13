"""
Simply done as stated in question with same steps:
Only optimization is:
    i) ans+=('z' - (sum % 26)) ->Better going with List because string ans need to completely first copy each char of previous ans and then add to assign new string(Immutable)

TC - O(Total chaacter), SC - O(1) {as output space is excluded}
"""

class Solution:
    def mapWordWeights(self, words: List[str], weights: List[int]) -> str:
        ans=[]
        for s in words:
            sum=0
            for i in s:
                sum+=weights[ord(i)-ord('a')]
            ans.append(chr(ord('z')-(sum%26)))
        return ''.join(ans)