package Leetcode_POTD.July_2026;

/*
Doing it manually by creating adjacent list(BFS) or by reaching max dist each step to destination leads to TLE

Binary Lifting - Works as Lowest Common Ancestor
Make a sorted copy of nums(nlogn) and also a array to know index of element in nums(pos[index in nums]=index in sorted copy)
Similar to part1 of this question- 1 array for grouping(comp) to knoww whether path exist or not
Now precompute from each position, if steps taken (1,2,4,..2^(no. of bit in n)), where will it reach in sorted array-- (nlogn)
Now for each query start from highest step to coming down until it's greater than bigger element -- (logn)

TC - O(nlogn), SC - O(n)
*/ 

public class July_10 {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {// (value, original index)
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] value = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }
        // component id
        int[] comp = new int[n];
        for (int i = 1; i < n; i++) {
            comp[i] = comp[i - 1];
            if (value[i] - value[i - 1] > maxDiff)
                comp[i]++;
        }
        // farthest reachable in one jump
        int[] right = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && value[j] - value[i] <= maxDiff)
                j++;
            right[i] = j - 1;
        }
        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        int[][] up = new int[LOG][n];
        up[0] = right;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            if (u == v) {
                ans[q] = 0;
                continue;
            }
            int a = pos[u];
            int b = pos[v];
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            if (comp[a] != comp[b]) {
                ans[q] = -1;
                continue;
            }
            if (value[b] - value[a] <= maxDiff) {
                ans[q] = 1;
                continue;
            }
            int cur = a;
            int steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < b) {
                    cur = up[k][cur];
                    steps += 1 << k;
                }
            }
            if (up[0][cur] >= b)
                ans[q] = steps + 1;
            else
                ans[q] = -1;
        }
        return ans;
    }
}
