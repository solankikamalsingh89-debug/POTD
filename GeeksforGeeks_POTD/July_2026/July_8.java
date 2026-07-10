package GeeksforGeeks_POTD.July_2026;

/*
For p and q seperately make boolean matrix of all cells  - Can be reached by that tower or not according to conditions(By BFS)
Then, find common in both --> ANS

TC - O(nm), SC - O(nm)
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class July_8 {
    public int countCoordinates(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ans=0;
        boolean[][] p=new boolean[n][m];
        Queue<int[]> a=new ArrayDeque<>();
        for(int i=0;i<n;i++) a.offer(new int[]{i,0});
        for(int i=1;i<m;i++) a.offer(new int[]{0,i});
        while(!a.isEmpty()){
            int[] ac=a.poll();
            if(!p[ac[0]][ac[1]]){
                p[ac[0]][ac[1]]=true;
                if(ac[1]+1<m &&  mat[ac[0]][ac[1]]<=mat[ac[0]][ac[1]+1]) a.offer(new int[]{ac[0],ac[1]+1});
                if(ac[1]-1>=0 &&  mat[ac[0]][ac[1]]<=mat[ac[0]][ac[1]-1]) a.offer(new int[]{ac[0],ac[1]-1});
                if(ac[0]+1<n &&  mat[ac[0]][ac[1]]<=mat[ac[0]+1][ac[1]]) a.offer(new int[]{ac[0]+1,ac[1]});
                if(ac[0]-1>=0 &&  mat[ac[0]][ac[1]]<=mat[ac[0]-1][ac[1]]) a.offer(new int[]{ac[0]-1,ac[1]});
            }
        }
        boolean[][] q=new boolean[n][m];
        for(int i=0;i<n;i++) a.offer(new int[]{i,m-1});
        for(int i=0;i<m-1;i++) a.offer(new int[]{n-1,i});
        while(!a.isEmpty()){
            int[] ac=a.poll();
            if(!q[ac[0]][ac[1]]){
                q[ac[0]][ac[1]]=true;
                if(p[ac[0]][ac[1]]) ans++;
                if(ac[1]+1<m &&  mat[ac[0]][ac[1]]<=mat[ac[0]][ac[1]+1]) a.offer(new int[]{ac[0],ac[1]+1});
                if(ac[1]-1>=0 &&  mat[ac[0]][ac[1]]<=mat[ac[0]][ac[1]-1]) a.offer(new int[]{ac[0],ac[1]-1});
                if(ac[0]+1<n &&  mat[ac[0]][ac[1]]<=mat[ac[0]+1][ac[1]]) a.offer(new int[]{ac[0]+1,ac[1]});
                if(ac[0]-1>=0 &&  mat[ac[0]][ac[1]]<=mat[ac[0]-1][ac[1]]) a.offer(new int[]{ac[0]-1,ac[1]});
            }
        }
        return ans;
    }
}
