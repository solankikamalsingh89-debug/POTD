package GeeksforGeeks_POTD.July_2026;

/*
Just check each alphabet last and first occurence and spot max gap

TC - O(n), SC - O(1)
*/

public class July_5 {
    public int maxCharGap(String s) {
        int[] first_occ=new int[26];
        int[] last_occ=new int[26];
        for(int i=0;i<s.length();i++){
            if(first_occ[s.charAt(i)-'a']==0) first_occ[s.charAt(i)-'a']=i+1;
        }
        for(int i=s.length()-1;i>=0;i--){
            if(last_occ[s.charAt(i)-'a']==0) last_occ[s.charAt(i)-'a']=i+1;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(first_occ[i]!=last_occ[i]) ans=Math.max(ans,last_occ[i]-first_occ[i]);
        }
        return ans-1;
    }
}
