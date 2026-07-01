package Leetcode_POTD.June_2026;

/*
Method 1: (JAVA Code)
    Used two pointer:
        If number of char used are 3 increase previous(i) pointer
        Else substract from total (No. of non-empty subarray in between i and j)

    TC - O(n), SC - O(1)
Method 2: (PYTHON Code)
    Starting last indices with -1, count number of subarrays till iterated length containing all 3 char

    TC - O(n), SC - O(1)
*/

public class June_30 {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        long ans=((long)n*(n+1))/2;
        int i=0, j=0;
        int abc[]=new int[3];
        int used=0;
        while(j<n){
            if(++abc[s.charAt(j)-'a']==1) used++;
            if(used==3){
                while(--abc[s.charAt(i)-'a']!=0) i++;
                i++;
                used--;
            }
            ans-=(++j-i);
        }
        return (int)ans;
    }
}
