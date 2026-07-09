package Leetcode_POTD.July_2026;

/*
New Learning: Topological Sort( For DAG(Directed acyclic graphs) only) -- In this nodes are arranged such that children of any level will come after it for all elements
                    - Topo Sort: Start with nodes having no parent (adding them in queue), then follow each's children(decreement it's in_edges) and add in queue if for any in_edges become zero

After topological sort of nodes.
Create a list of all possible cost (As from these we will choose answer) in ascending order
Then with binary search technique check for each by function(ok) if it can be answer, if yes search in higher else in lower cost values

E=no. of edges, V= no. of vertices
TC - O(ElogE)+O(logE)×O(V+E) {Sort cost + Binary Search*ok function} = O(ElogE), SC - O(V+E) {Graph(V+E) + cost(E) + (topo_sort + DP(ok) + Queue + indegree)(V)}
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

class July_3 {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        ArrayList<int[]> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] i:edges){
            if(online[i[0]] && online[i[1]]){
                adj[i[0]].add(new int[]{i[1],i[2]});
                inedg[i[1]]++;
                cost.add(i[2]);
            }
        }
        Collections.sort(cost);
        ArrayList<Integer> topo_sort=new ArrayList<>();
        Queue<Integer> topo=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(inedg[i]==0) {
                topo.offer(i);
                topo_sort.add(i);
            }
        }
        while(!topo.isEmpty()){
            for(int[] i:adj[topo.poll()]){
                inedg[i[0]]--;
                if(inedg[i[0]]==0) {
                    topo.offer(i[0]);
                    topo_sort.add(i[0]);
                }
            }
        }
        int l=0, h=cost.size()-1;
        int ans=-1;
        while(l<=h){
            int mid=(h+l)/2;
            if(ok(topo_sort, adj, cost.get(mid), k, topo_sort.size())){
                l=mid+1;
                ans=cost.get(mid);
            }
            else h=mid-1;
        }
        return ans;
    }
    public boolean ok(ArrayList<Integer> a, ArrayList<int[]> adj[], int c, long k, int m){
        long[] dp=new long[m];
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0]=0;
        for(int i:a){
            if(dp[i]>k) continue;
            for(int[] j:adj[i]){
                if(j[1]>=c) dp[j[0]]=Math.min(dp[j[0]],dp[i]+j[1]);
            }
        }
        return dp[m-1]<=k;
    }
}