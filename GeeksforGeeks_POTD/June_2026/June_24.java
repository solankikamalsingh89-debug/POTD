package GeeksforGeeks_POTD.June_2026;

/*
Recursion or dfs with modification to explore first shorter to longer and first right thwn down.
For optimization use a boolean array to know that this can't be included in path(Because we may explore same sub-path from different routes which didn't reach end)

TC - O(n^3){Each state(n^2) resolved once with n iterations}, SC - O(n^2){Memorization + Recursion Stack}
*/

import java.util.stream.Stream;
import java.util.stream.Collectors;

class June_24 {
    private boolean dp[][];
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n=mat.length-1;
        if(mat[0][0]==0) return new ArrayList<>(List.of(new ArrayList<>(List.of(-1))));
        ArrayList<ArrayList<Integer>> ans= Stream.generate(() -> new ArrayList<>(Collections.nCopies(n+1, 0))) .limit(n+1) .collect(Collectors.toCollection(ArrayList::new));
        dp=new boolean[n+1][n+1];
        if(dfs(n,mat,ans,0,0)) return ans;
        return new ArrayList<>(List.of(new ArrayList<>(List.of(-1))));
    }
    private boolean dfs(int n, int[][] mat, ArrayList<ArrayList<Integer>> ans, int i, int j){
        if(dp[i][j]) return false;
        if(i+j==2*n) {
            ans.get(n).set(n,1);
            return true;
        }
        for(int k=1;k<=mat[i][j];k++){
            if(j+k<=n && mat[i][j+k]!=0){
                if(dfs(n, mat, ans, i, j+k)){
                    ans.get(i).set(j,1);
                    return true;
                }
                else dp[i][j+k]=true;
            }
            if(i+k<=n && mat[i+k][j]!=0){
                if(dfs(n, mat, ans, i+k, j)){
                    ans.get(i).set(j,1);
                    return true;
                }
                else dp[i+k][j]=true;
            }
            if(i+k>n && j+k>n) {
                dp[i][j]=true;
                return false;
            }
        }
        dp[i][j]=true;
        return false;
    }
}