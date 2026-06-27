package GeeksforGeeks_POTD.June_2026;

import java.util.ArrayList;

/*
I did it with brute force maintaining the character occured if either appeared previously of matching with String2 to add it as another option to get selected for all indices of the character in String2
With this reaching last char with possible ways is the answer.

TC - O(n^2), SC - O(len(s2))

We can try other methods like:
1. Recursion - O(2^n)--> either skip or select the char if equal
2. Dynamic programming - O(n*m)--> Create 2D array(n*m), dp[i][j] represents number of ways selecting first 'j' in s2 in first 'i' in s1 filling with same logic if equal either skip or select
    (countWays2)
*/

class June_26 {
    public static int countWays(String s1, String s2) { //MyCode
        if(s2.length()>s1.length()) return 0;
        if(s1.equals(s2)) return 1;
        boolean[] arr=new boolean[26];
        ArrayList<Integer>[]a = new ArrayList[26];
        long[] no=new long[s2.length()];
        int c=0;
        for(int i=0;i<s1.length();i++){
            char q=s1.charAt(i);
            if(c<s2.length() && s2.charAt(c)==q){
                if(!arr[q-'a']){
                    a[q-'a']=new ArrayList<>();
                    arr[q-'a']=true;
                }
                a[q-'a'].add(c);
                c++;
            }
            if(arr[q-'a']){
                for(int j=a[q-'a'].size()-1;j>=0;j--){
                    if(a[q-'a'].get(j)==0){
                        no[a[q-'a'].get(j)]++;
                        break;
                    }
                    no[a[q-'a'].get(j)]=(no[a[q-'a'].get(j)]+no[a[q-'a'].get(j)-1])%1000000007; //if(a[j]-1==a[j]) no[a.get(j)]+=no[a.get(j-1)];
                }
            }
        }
        return (int)no[s2.length()-1];
    }

    public static int countWays2(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        long dp[]=new long[m+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>0;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[j]=(dp[j-1]+dp[j])%1_000_000_007;
                }
            }
        }
        return (int)dp[m];
    }
}