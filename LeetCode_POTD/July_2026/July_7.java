package Leetcode_POTD.July_2026;

/*
Easy - do as stated

TC - O(log10(n)), SC - O(1)
*/

public class July_7 {
    public long sumAndMultiply(int n) {
        long sum=0;
        long m=0;
        int idx=1;
        while(n>0){
            int r=n%10;
            if(r!=0){
                sum+=r;
                m+=r*idx;
                idx*=10;
            }
            n/=10;
        }
        return sum*m;
    }
}
