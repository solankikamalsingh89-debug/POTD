package Leetcode_POTD.July_2026;

/*
Convert string to 2d array to make easy access
Use memoization to prevent TLE(DP) in dfs to search path with maintaining at each point, how many path for maximum scores are available

TC - O(n^2), SC - O(n^2)
*/

import java.util.Arrays;
import java.util.List;

public class July_5 {
    int [][][] memo;
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        memo=new int[n][n][2];
        int[][] chess=new int[n][n];
        for(int i=0;i<n;i++){
            String cur=board.get(i);
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j], -1);
                char c=cur.charAt(j);
                if(c=='X') chess[i][j]=-1;
                else if(c-'0'>0 && c-'0'<=9) chess[i][j]=c-'0';
                else chess[i][j]=0;
            }
        }
        int[] ans=dfs(chess,n-1,n-1);
        if(ans[0]<0) return new int[]{0,0};
        else return ans;
    }
    private int[] dfs(int[][] chess, int i, int j){
        if(i==0 && j==0) {
            return new int[]{0,1};
        }
        if(i<0 || j<0 || chess[i][j]==-1) return new int[]{Integer.MIN_VALUE,0};
        if (memo[i][j][0]!=-1) return memo[i][j];
        int[] a=dfs(chess,i-1,j-1);
        int[] b=dfs(chess,i-1,j);
        int[] c=dfs(chess,i,j-1);
        int m=Math.max(a[0],Math.max(b[0],c[0]));
        long w=0;
        if(a[0]==m) w+=a[1];
        if(b[0]==m) w+=b[1];
        if(c[0]==m) w+=c[1];
        return memo[i][j]=new int[]{chess[i][j]+m,(int)(w%1000000007)};
    }
}
