package Leetcode_POTD.July_2026;

/*
Create the graph adjacency list and then for each if have not been visited yet, traverse complete connected subgraph and check if all nodes were having (subgraph size)-1 edges to ensure completeness

TC - O(n), SC - O(n)
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class July_11 {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] edg=new int[n];
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] i:edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
            edg[i[0]]++;
            edg[i[1]]++;
        }
        int ans=0;
        Queue<Integer> l=new ArrayDeque<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                boolean flg=true;
                int cnt=edg[i]-1;
                vis[i]=true;
                for(int j:adj[i]) l.offer(j);
                while(!l.isEmpty()){
                    int a=l.poll();
                    if(vis[a]) continue;
                    vis[a]=true; 
                    if(cnt--<0 || edg[i]!=edg[a]) flg=false;
                    for(int j:adj[a]) l.offer(j);
                }
                if(flg) ans++;
            }
        }
        return ans;
    }
}
