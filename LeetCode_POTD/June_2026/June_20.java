package Leetcode_POTD.June_2026;

/*
Think restrictions mentioning height of i-th building be it's height actually.
Now lower the heights of restrictions so that it can be reached by its just neighbours(How will we check this-- by comparing steps we have(or distance between 2 restrictions) and their heights)
This will be first done from front traversal.
Now there is chance of some cases to be left to handle ( e.g. We decreased two restrictions simultaneously, then first decreased may have chance that now next restriction can't be reached with steps)-- So, a final check by back traversal with finding max height simultaneously(How height to be calculated?)
Height is calculated by steps(Left after maintaining both at least height of both)

TC - O(nlogn){Its beacuse of sorting array, otherwise trsversal is fdone in O(n)}, SC- O(1)
*/

import java.util.Arrays;

public class June_20 {
    public int maxBuilding(int n, int[][] restrictions) {
        int l=restrictions.length;
        if(l==0) return n-1;
        Arrays.sort(restrictions, (a,b)-> Integer.compare(a[0], b[0]));
        int max=0;
        int steps=restrictions[0][0]-1-restrictions[0][1];
        if(steps<0) restrictions[0][1]+=steps;
        for(int i=1;i<l;i++){
            if(restrictions[i-1][1]>=restrictions[i][1]){
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i-1][1]+restrictions[i][1];
                if(steps<0) restrictions[i-1][1]+=steps;
            }else{
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i][1]+restrictions[i-1][1];
                if(steps<0) restrictions[i][1]+=steps;
            }
        }
        for(int i=l-1;i>0;i--){
            if(restrictions[i-1][1]>restrictions[i][1]){
                steps=restrictions[i][0]-restrictions[i-1][0]-restrictions[i-1][1]+restrictions[i][1];
                if(steps<0) {
                    restrictions[i-1][1]+=steps;
                    max=Math.max(max,restrictions[i-1][1]);
                }
                else{
                    max=Math.max(max,restrictions[i-1][1]+(steps)/2);
                }
            }
            else{
                max=Math.max(max,restrictions[i][1]+(restrictions[i][0]-restrictions[i-1][0]-restrictions[i][1]+restrictions[i-1][1])/2);
            }
        }
        max=Math.max(max,restrictions[0][1]+(restrictions[0][0]-restrictions[0][1]-1)/2);
        return Math.max(max,n-restrictions[l-1][0]+restrictions[l-1][1]);
    }
}
