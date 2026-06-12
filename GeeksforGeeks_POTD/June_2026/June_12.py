"""
Define hashmap to keep track of number of diiferent strings occuring with what frequency
With traversal, if number of string>2 or number of strings with frequency>1 return false
Otherwise return true
"""
class Solution:
    def kSubstr(self, s: str, k: int) -> bool:
        map={}
        o=False
        i=0
        while i<len(s):
            if s[i:i+k] in map:
                if map[s[i:i+k]]==1:
                    if o:
                        return False;
                    else:
                        o=True
                map[s[i:i+k]]=2
            else:
                map[s[i:i+k]]=1
            if len(map)>2:
                return False
            i+=k;
        return True