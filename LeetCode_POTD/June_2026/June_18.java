package Leetcode_POTD.June_2026;

/*
Count angle in double for both hands from 12.
Then find difference in hands, then check the minimum angle.
*/

public class June_18 {
    public double angleClock(int hour, int minutes) {
        double hr=(hour%12)*30+(minutes*0.5);
        double mn=minutes*6;
        double ans=Math.abs(hr-mn);
        return Math.min(ans,360-ans);
    }
}
