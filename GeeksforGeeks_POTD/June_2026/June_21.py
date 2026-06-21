"""
Mark the first occurence as rank/position of each character (alphabet)
Then check from front traversal of string to see if any position tha must have came earlier but came later-- Mark that alphabet and alphabet at its place
Using translate with mapping prepare answer string by replacing only those two characters

TC - O(s.size()), SC - O(1)
"""

class Solution:
    def chooseSwap(self, s):
        f_occ=[-1]*26
        j=1
        for i in s:
            if f_occ[ord(i)-97]==-1:
                f_occ[ord(i)-97]=j
                j+=1
        j=1
        a1=a2='a'
        for i in range(26):
            if f_occ[i]==j:
                j+=1
            elif f_occ[i]!=-1:
                a1=chr(i+97)
                a2=chr(f_occ.index(j)+97)
                break;
        return s.translate(str.maketrans({a1:a2, a2:a1}))