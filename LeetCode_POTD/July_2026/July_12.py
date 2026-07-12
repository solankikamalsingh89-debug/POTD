"""
Made a array with index of element, sort it and then replace number by respective rank getting by traversal of sorted array

TC - O(n), SC - O(n)
"""

class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        a=sorted(set(arr))
        rank={x:i+1 for i,x in enumerate(a)}
        for i in range(len(arr)):
            arr[i]=rank.get(arr[i]);
        return arr