package GeeksforGeeks_POTD.June_2026;

/*
New Learning: Value for which minimum operation will be required is Median.

So traverse array and maintain index for values lesser than median. (As median can increase only- sorted array)
Maintain sum in 2 parts(less than median and greater than equal to median) to get how much operations are required to make all equal to median
TC - O(n), SC - O(1)
*/

import java.util.ArrayList;

public class June_19 {
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>(arr.length);
        int lsum=arr[0], hsum=0;
        int lidx=1; //Less than it in lsum
        ans.add(0);
        while(lidx<arr.length && arr[lidx]==arr[lidx-1]){ans.add(0); lsum+=arr[0]; lidx++;}
        for (int i=lidx;i<arr.length;i++){
            int avg=(arr[(i+1)/2]+arr[i/2])/2;
            hsum+=arr[i];
            while(arr[lidx]<avg){lsum+=arr[lidx]; hsum-=arr[lidx]; lidx++;}
            ans.add(hsum-(avg*(i-lidx+1))-lsum+(avg*lidx));
        }
        return ans;
    }
}
