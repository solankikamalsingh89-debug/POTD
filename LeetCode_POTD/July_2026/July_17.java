package Leetcode_POTD.July_2026;

/*
As per queries' constraint, we should do it in approximately nlogn.
So to get GCD count:
    - Firstly, precompute factors of each number till highest number
    - Then, using it find from given array nums, count number of elements that are divisible by that number as - multiple_cnt
    - As multiple_cnt is now only as count if this number divides number in nums, so to pair in 2, use nC
    - Now to know count of HCF exactly (As till now it was counting e.g. HCF=4 in HCF=2 as well) as that number, we have to remove these cases with the help of factors array use of each number
    - Now we have count to each number as HCF- make its prefix array
    ----- Precomputaion is done
    For each query, get answer by binary search in prefix array

TC - O(nlogn), SC - O(mlogm)
*/
public class July_17 {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length;
        int m=0;
        for(int i=0;i<n;i++) m=Math.max(nums[i],m);
        ArrayList<Integer>[] factor=new ArrayList[m+1];
        for(int i=1;i<=m;i++) factor[i]=new ArrayList<>();
        for(int i=1;i<=m;i++){
            for(int j=1;i*j<=m;j++) factor[j*i].add(i);
        }
        long [] multiple_cnt=new long[m+1];
        for(int i:nums){
            for(int j:factor[i]) multiple_cnt[j]++;
        }
        //Now making multiple_cnt to number count having that gcd
        for(int i=1;i<=m;i++) multiple_cnt[i]=((multiple_cnt[i]-1)*multiple_cnt[i])/2;
        for(int i=m;i>=2;i--){
            if(multiple_cnt[i]==0) continue;
            for(int j:factor[i]) if(j!=i) multiple_cnt[j]-=multiple_cnt[i];
        }
        //Now use multiple_cnt to get prefix array for count of gcd till that value
        for(int i=1;i<=m;i++) multiple_cnt[i]+=multiple_cnt[i-1];
        //Use binary search to get the number
        int k=queries.length;
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            long q=queries[i];
            ans[i]=binary_search(q+1,multiple_cnt,m);
        }
        return ans;
    }
    private int binary_search(long k, long[] a, int n){ // Return index of place either just less than or equal to k
       int l=0,h=n;
        int mid=0;
        while(l<h){
            mid=(l+h)/2;
            if(a[mid]<k) l=mid+1;
            else if(a[mid]>k) h=mid-1;
            else break;
        }
        while(mid>0 && a[mid]>=k) mid--;
        while (a[mid]<k) mid++;
        while (mid>0 && a[mid-1]==a[mid]) mid--;
        return mid;
    }
}
