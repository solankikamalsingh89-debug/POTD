package Leetcode_POTD.July_2026;

/*
Storing minimum cost from all nodes with making adjacency list for graph
Then traverse BFS on graph till all nodes get as leaf- and each time maintain minimum of all

TC - O(n), SC - O(n)
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class July_4 {
    public int minScore(int n, int[][] roads) {
        int tentans=10000;
        int[] min=new int[n+1];
        Arrays.fill(min,10000);
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++) adj[i]=new ArrayList<>();
        for(int[] i:roads){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
            tentans=Math.min(tentans,i[2]);
            min[i[0]]=Math.min(min[i[0]],i[2]);
            min[i[1]]=Math.min(min[i[1]],i[2]);
        }
        if(min[1]==tentans) return tentans;
        Queue<Integer> l = new ArrayDeque<>();
        l.offer(1);
        int ans=10000;
        while(!l.isEmpty()){
            int a=l.poll();
            for(int i:adj[a]){
                if(min[i]==0) continue;
                ans=Math.min(ans,min[i]);
                if(ans==tentans) return tentans;
                l.offer(i);
                min[i]=0;
            }
        }
        return ans;
    }
}
