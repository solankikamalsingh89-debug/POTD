"""
Maitain a freq array for how many time difference in 1 to 0 have occured till then, with previous step added cases--
    As if 0 appears , it will get decreased by frequency of next position
    else if 1, then get increased by frequncy of current poisition

TC - O(n), SC - O(n)   
"""

class Solution:
    def countSubstring(self, s):
        # code here
        n = len(s)
        pref_balance_counts = [0] * (2 * n + 1)
        curr_balance = n
        pref_balance_counts[curr_balance] = 1
        curr_count = total_count = 0
        for d in s:
            if d == "1":
                curr_count += pref_balance_counts[curr_balance]
                curr_balance += 1
            else:
                curr_balance -= 1
                curr_count -= pref_balance_counts[curr_balance]
            total_count += curr_count
            pref_balance_counts[curr_balance] += 1
        return total_count