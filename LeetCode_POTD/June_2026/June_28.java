package Leetcode_POTD.June_2026;

/*
Sort the array (O(nlong), O(1)) and then check if that number appears or some another greater number needs so be converted to it (JAVA Code)
Without using sort, just iterate the arr to get freq of all numbers appearing (maximum can become n, so greater than n--> treat as n){Counting sort(O(n), O(n))} -> Then same logic (PYTHON Code)
*/

import java.util.Arrays;

public class June_28 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int a=1;
        for (int i=1;i<arr.length;i++){
            a=Math.min(a+1,arr[i]);
        }
        return a;
    }
}
