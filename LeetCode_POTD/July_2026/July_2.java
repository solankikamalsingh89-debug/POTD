package Leetcode_POTD.July_2026;

/*
BFS - If could reach destination , return true
TC - O(n*m), SC - O(n*m)

Further Optimization:
    Using arraydeque faster or also can use simple circular array implementation
    Making of Direction array ={0,1,0,-1,0} 
    If constraint are large then copy list in array exactly to avoid multiple boxing/unboxing
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class July_2 {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Queue<int[]> line = new LinkedList<>();
        int m=grid.size()-1;
        int n=grid.get(0).size()-1;
        int vis[][]=new int[m+1][n+1];
        int k=grid.get(m).get(n);
        line.offer(new int[]{0,0,health});
        while(!line.isEmpty()){
            int a[]=line.poll();
            if(a[0]<0 || a[1]<0 || a[0]>m || a[1]>n || a[2]<1+k) continue;
            if(vis[a[0]][a[1]]>=a[2]) continue;
            if(a[0]==m && a[1]==n) return true;
            vis[a[0]][a[1]]=a[2];
            line.offer(new int[]{a[0]+1,a[1],a[2]-grid.get(a[0]).get(a[1])});
            line.offer(new int[]{a[0]-1,a[1],a[2]-grid.get(a[0]).get(a[1])});
            line.offer(new int[]{a[0],a[1]+1,a[2]-grid.get(a[0]).get(a[1])});
            line.offer(new int[]{a[0],a[1]-1,a[2]-grid.get(a[0]).get(a[1])});
        }
        return false;
    }
}
