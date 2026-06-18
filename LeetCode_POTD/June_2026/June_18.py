"""
Count angle for both hands from 12.
Then find difference in hands, then check the minimum angle.
"""

class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        a=abs((hour%12)*30+(minutes/2)-(minutes*6))
        return min(360-a,a)