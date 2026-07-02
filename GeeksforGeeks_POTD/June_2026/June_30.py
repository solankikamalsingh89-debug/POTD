"""
We created an arraylist to store number coming at index after deleting other elements.
So, if a number is bigger than last element, just add it in the end. Else, traverse backward until find number just larger or equal to it to replace it with previous index holding(Because if any is going to take the further sequence with more length, it have t overcome previous sequence length )

TC - O(n^2), SC - O(n)
"""

class Solution:
    def minInsAndDel(self, a, b):
        # code here
        from bisect import bisect_left
        n, m = len(a), len(b)
        b_set = set(b)
        lis = []
        for a_elem in a:
            if a_elem not in b_set:
                continue
            i = bisect_left(lis, a_elem)
            if i == len(lis):
                lis.append(a_elem)
            else:
                lis[i] = a_elem
        return n + m - 2 * len(lis)
