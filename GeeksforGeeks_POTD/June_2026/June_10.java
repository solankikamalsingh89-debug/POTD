package GeeksforGeeks_POTD.June_2026;
/*
For every value in arr, checked with binary search itself to check if could be found
TC - O(nlogn), SC - O(1)
*/
public class June_10 {
    public int binarySearchable(int[] arr) {
        int ans =0;
        int n =arr.length;
        for(int i=0;i<n;i++){
            int l =0;
            int r= n-1;
            while (l<=r){
                int mid = l+(r-l)/2;
                if(arr[mid]==arr[i]) {ans++;break;}
                else if (arr[mid]<arr[i]){
                    l=mid+1;
                    if(i<l) break;
                }else{
                    r= mid-1;
                    if(i>r) break;
                }
            }
        }
        return ans;
    }
}
