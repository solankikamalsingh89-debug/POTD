package Leetcode_POTD.July_2026;

/*
Divide in groups (partiotion from point where differnce in neighbours is more than maxDiff)
If queries point in same group return yes.

TC - O(n+m), SC - O(n)
*/

public class July_9 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int a[]=new int[n];
        int grp=1;
        a[0]=1;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=maxDiff) a[i+1]=grp;
            else a[i+1]=++grp;
        }
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            if(a[queries[i][0]]==a[queries[i][1]]) ans[i]=true;
        }
        return ans;
    }
}
