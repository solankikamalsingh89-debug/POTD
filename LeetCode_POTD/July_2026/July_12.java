package Leetcode_POTD.July_2026;

/*
Made a array with index of element, sort it and then replace number by respective rank getting by traversal of sorted array

TC - O(n), SC - O(n)
*/

import java.util.Arrays;

public class July_12 {
    public int[] arrayRankTransform(int[] arr) {
        int[][] ans=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            ans[i][0]=arr[i];
            ans[i][1]=i;
        }
        Arrays.sort(ans,(a,b)->Integer.compare(a[0],b[0]));
        int g=0;
        int p=Integer.MIN_VALUE;
        for(int[] i:ans){
            if(p<i[0]) {
                g++;
                p=i[0];
            }
            arr[i[1]]=g;
        }
        return arr;
    }
}
