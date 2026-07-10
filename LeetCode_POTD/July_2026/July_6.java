package Leetcode_POTD.July_2026;

import java.util.Arrays;

/*
Sort intervals in ascending order to starting of interval, and in descending to ending of interval  to break ties
Then traverse interval and if ending till now has reaced more than it exclude it

TC - O(nlogn), SC - O(1)
*/

public class July_6 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int h=intervals[0][1];
        int ans=1;
        for(int i=1;i<intervals.length;i++){
            if(h<intervals[i][1]){
                ans++;
                h=intervals[i][1];
            }
        }   
        return ans;
    }
}
