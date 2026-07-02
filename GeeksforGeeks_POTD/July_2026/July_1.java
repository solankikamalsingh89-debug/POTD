package GeeksforGeeks_POTD.July_2026;

/*
{Similar to Kadane's Algorithm(To find maximum subarray sum) - Dyanamic Programming}
With iteration keep track of 2(Maxmimum till index with and without skipping till now).
Each time update answer as it can reduce as well

TC - O(n), SC - O(1)
*/

public class July_1 {
    public int maxSumSubarray(int[] arr) {
        int maxAtIdxNoSkip=arr[0];
        int maxAtIdxSkip=arr[0];
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            maxAtIdxSkip=Math.max(maxAtIdxNoSkip,maxAtIdxSkip+arr[i]);
            maxAtIdxNoSkip=Math.max(arr[i],maxAtIdxNoSkip+arr[i]);
            ans=Math.max(ans,Math.max(maxAtIdxNoSkip,maxAtIdxSkip));
        }
        return ans;
    }
}
