"""
Sort intervals in ascending order to starting of interval, and in descending to ending of interval  to break ties
Then traverse interval and if ending till now has reaced more than it exclude it

TC - O(nlogn), SC - O(1)
"""

class Solution:
    def removeCoveredIntervals(self, intervals):
        intervals.sort(key=lambda x: (x[0], -x[1]))
        h=intervals[0][1]
        ans=1
        for i in range(1,len(intervals)):
            if h<intervals[i][1]:
                ans+=1
                h=intervals[i][1]
        return ans