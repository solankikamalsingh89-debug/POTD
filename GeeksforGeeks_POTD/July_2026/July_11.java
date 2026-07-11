package GeeksforGeeks_POTD.July_2026;

/*
Doing DFS for unvisited points in particular path(dfs) only to get maximum from all direction to pass previous dfs call

TC - O(4^nm), SC - O(nm)
*/

public class July_11 {
    int[] dir={0,1,0,-1,0};
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if(mat[xs][ys]+mat[xd][yd]<2) return -1;
        return dfs(mat,xs,ys,xd,yd,new boolean[mat.length][mat[0].length],mat.length,mat[0].length);
    }
    private int dfs(int[][] mat, int x, int y, int i, int j, boolean[][] vis, int n, int m){
        if(i==x && j==y) return 0;
        vis[i][j]=true;
        int mm=-1;
        for(int k=0;k<4;k++){
            int i1=i+dir[k];
            int j1=j+dir[k+1];
            if(i1<n && i1>=0 && j1<m && j1>=0 && mat[i1][j1]==1 && !vis[i1][j1]) mm=Math.max(mm,dfs(mat,x,y,i1,j1,vis,n,m));
        }
        vis[i][j]=false;
        if(mm==-1) return mm;
        return mm+1;
    }
}
