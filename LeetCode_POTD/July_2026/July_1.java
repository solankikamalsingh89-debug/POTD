package Leetcode_POTD.July_2026;

/*
FIrst we created a queue with all theives and then iterate with BFS of multiple sources increasing 1 distance from previous and marking it in grid(Representing max minimum distance from theives)
Now as we have grid showing distance - Iterate from (0,0) to others keeping maximum distance iteration first

TC - O(n^2*log(n^2)){As used priority queue}, SC - O(n^2)
*/

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class July_1 {
    int grid[][];
    int n;
    static int[] dir={0,1,0,-1,0};
    public int maximumSafenessFactor(List<List<Integer>> grid1) {
        n=grid1.size();
        // Check if theif itself at source or destination
        if(grid1.get(0).get(0)==1 || grid1.get(n-1).get(n-1)==1) return 0;
        //Create a grid showing minimum distance from theif
        grid=new int[n][n];
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> theif_dist = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid1.get(i).get(j)==1){
                    theif_dist.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        while(!theif_dist.isEmpty()){
            int[] a=theif_dist.poll();
            for(int i=0;i<4;i++){
                int j=a[0]+dir[i];
                int k=a[1]+dir[i+1];
                if(j>=0 && j<n && k>=0 && k<n && !vis[j][k]){
                    theif_dist.offer(new int[]{j,k});
                    vis[j][k]=true;
                    grid[j][k]=grid[a[0]][a[1]]+1;
                }
            }
        }
        //Follow path with maximum minimum distance from theif
        vis=new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (s1, s2) -> Integer.compare(s2[2], s1[2])
        );
        pq.offer(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            if(a[0]==n-1 && a[1]==n-1) return a[2];
            if(vis[a[0]][a[1]]) continue;
            if(grid[a[0]][a[1]]==0) return 0;
            vis[a[0]][a[1]]=true;
            for(int p=0;p<4;p++){
                int i=a[0]+dir[p];
                int j=a[1]+dir[p+1];
                if(i<0 || j<0 || i>=n || j>=n ) continue;
                pq.offer(new int[]{i,j,Math.min(a[2],grid[i][j])});
            }
        }
        return 0;
    }
}
