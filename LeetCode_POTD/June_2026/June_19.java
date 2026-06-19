package Leetcode_POTD.June_2026;
/* Easy */
public class June_19 {
    public int largestAltitude(int[] gain) {
        int h=0;
        int ans=0;
        for (int i:gain){
            h+=i;
            ans=Math.max(h,ans);
        }
        return ans;
    }
}
