package GeeksforGeeks_POTD.July_2026;

/*
Maitain a freq array for how many time difference in 1 to 0 have occured till then, with previous step added cases--
    As if 0 appears , it will get decreased by frequency of next position
    else if 1, then get increased by frequncy of current poisition

TC - O(n), SC - O(n)    

*/

public class July_4 {
    public int countSubstring(String s) {
        //Something similar to somedays back LeetCode solved(Majority element subarrays for a target)
        int ans=0;
        int n=s.length();
        int[] freq=new int[2*n+1];
        int c=n;
        freq[c]=1;
        int pref=0; //Previous step pr kitne bn rhe the(if only taken till that step length)
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                pref-=freq[--c];
                freq[c]++;
            }else{
                pref+=freq[c];
                freq[++c]++;
            }
            ans+=pref;
        }
        return ans;
    }

}
