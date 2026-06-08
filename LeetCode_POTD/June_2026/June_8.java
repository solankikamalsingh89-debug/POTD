package Leetcode_POTD.June_2026;
/*
Normal Question: Take element in order in another memory space
*/

import java.util.ArrayList;

public class June_8 {
    public int[] pivotArray(int[] nums, int pivot) { //To keep less memory consumption
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();
        for(int i:nums){
            if(i<pivot)a1.add(i);
            else if(i>pivot)a2.add(i);
        }
        int i=0;
        for(int j:a1)nums[i++]=j;
        for(;i<nums.length-a2.size();i++) nums[i]=pivot;
        for(int j:a2) nums[i++]=j;
        return nums;
    }

    public int[] pivotArray1(int[] nums, int pivot) { //T keep lesser runtime(Preferred)
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }
            if (nums[j] > pivot) {
                result[right] = nums[j];
                right--;
            }
        }
        while (left <= right) {
            result[left] = pivot;
            left++;
        }
        return result;
    }
}