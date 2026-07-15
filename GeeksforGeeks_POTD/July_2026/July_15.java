package GeeksforGeeks_POTD.July_2026;

/*
With iteration check for such sequence and add traversal index with that itself, but to prevent not counting of equal numbers at boundary(where few countrd in previous one)-always check before starting if equal elements exist as well to count

TC - O(n), SC - O(1)
*/

public class July_15 {
    public int bitonic(int[] arr) {
        int ans=1;
		int i=0;
		int n=arr.length;
		while (i<n-ans){
		    int cur=1;
		    int j=i;
		    while(j>0 && arr[j]==arr[j-1]){ 
		        cur+=1;
		        j-=1;
		    }
		    while (i<n-1 && arr[i+1]>=arr[i]){ 
		        i+=1;
		        cur+=1;
		    }
		    while (i<n-1 && arr[i+1]<=arr[i]){ 
		        i+=1;
		        cur+=1;
		    }
		    ans=Math.max(ans,cur);
		}
	    return ans;
    }
}
