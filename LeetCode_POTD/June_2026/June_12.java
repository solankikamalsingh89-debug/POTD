package Leetcode_POTD.June_2026;

/*
As there are multiple different queries we have to optimize the way to find distance between 2 nodes of query -> Lowest Common Ancestor(Binary Lifting)( O(logn) per query, processing time O(nlogn) )
To prevent stack overflow for skewed tree cases- we prefer BFS over DFS
1. Building Tree: (O(nlogn))
    Make arraylist for adjacent nodes of each node
    Using Queue traverse BFS starting by Node 1 with mentioning depth of node in array depth
    Define LOG for maximum size of ancestors going up on base 2(not mentioning each node)--> up[n+1][LOG]
    up[node'val][ancestor no.] (If ancestor no. = 0 -> 1 step up, 1 -> 2 step up, 2 -> 4 step up ...) (up[node][j] =up[up[node][j - 1]][j - 1], j=ancestor no.)
2. Resolving Query: O(logn)
    Pass (dist-1) between node in solvex function to get answer(2^(dist-1)%1_000_000_007)
    How to get dist:
        Firstly find differnce in depth, then make both at same depth(min of both node's depth)-> To make depth equal use binary system to update node
        Then from the top(root), check with decreasing ancestor no. to react lowest commmon ancestror(if different ancestor then , safe to move upward)
*/

import java.util.ArrayDeque;
import java.util.ArrayList;

public class June_12 {
    private int[][] up;
    private int[] depth;
    private int LOG;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        buildTreeBFS(edges, n);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int dist = distance(u, v);
            ans[i] = solvex(2, dist - 1, 1_000_000_007);
        }

        return ans;
    }
    private void buildTreeBFS(int[][] edges, int n) {
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        vis[1] = true;
        depth[1] = 0;
        up[1][0] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    depth[nxt] = depth[cur] + 1;
                    up[nxt][0] = cur;
                    q.offer(nxt);
                }
            }
        }
        for (int j = 1; j < LOG; j++) {
            for (int node = 1; node <= n; node++) {
                up[node][j] =up[up[node][j - 1]][j - 1];
            }
        }
    }
    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[a] - depth[b];
        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                a = up[a][j];
            }
        }
        if (a == b) {
            return a;
        }
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[a][j] != up[b][j]){
                a = up[a][j];
                b = up[b][j];
            }
        }
        return up[a][0];
    }
    private int distance(int u, int v) {
        int lca = lca(u, v);
        return depth[u]+ depth[v]- 2 * depth[lca];
    }
    private int solvex(long base, long exp, int mod) {
        if (exp < 0) return 0;
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int) res;
    }
}
