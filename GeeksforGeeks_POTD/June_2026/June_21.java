package GeeksforGeeks_POTD.June_2026;

/*
Mark the first occurence as rank/position of each character (alphabet)
Then check from front traversal of string to see if any position tha must have came earlier but came later-- Mark that alphabet and alphabet at its place
Using StringBuilder prepare answer string by replacing only those two characters

TC - O(s.size()), SC - O(1)
*/

public class June_21 {
    public String chooseSwap(String s) {
        int[]a=new int[26]; //First idx of appearing
        int j=1;
        for(int i=1;i<=s.length();i++){
            if(a[s.charAt(i-1)-'a']==0) a[s.charAt(i-1)-'a']=j++;
        }
        j=1;
        char a1='a',a2='a';
        for(int i=0;i<26;i++){
            if(a[i]==j) j++;
            else if(a[i]!=0){
                a1+=i;
                for(int k=0;k<26;k++){
                    if(a[k]==j){
                        a2+=k;
                        break;
                    }
                }
                break;
            }
        }
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==a1) ans.append(a2);
            else if (s.charAt(i)==a2) ans.append(a1);
            else ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
