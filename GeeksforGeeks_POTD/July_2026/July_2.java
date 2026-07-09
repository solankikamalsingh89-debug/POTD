package GeeksforGeeks_POTD.July_2026;

/*
Maitained a boolean array of k-size to maintain record of remainder of sum we have by elements till iterated
(Whatever sum has acheived earlier - add new element to mark new element arriving)
-Can also do the same with recurion as well

TC - O(n*k), SC - O(k)
*/

import java.util.ArrayList;

public class July_2 {
    public boolean divisibleByK(int[] arr, int k) {
        int n=arr.length;
        if(n>k) return true; //Will always make remainder from sum=0
        boolean dp[]=new boolean[k];
        for(int i=0;i<n;i++){
            arr[i]%=k;
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<k;j++){
                if(dp[j]){
                    a.add((j+arr[i])%k);
                }
            }
            for(int k1:a) dp[k1]=true;
            if(dp[0]){
                return true;
            }
            dp[arr[i]]=true;
        }
        return dp[0];
    }
}
