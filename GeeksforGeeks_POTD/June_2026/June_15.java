package GeeksforGeeks_POTD.June_2026;

/*
Maintain a array dp for storing minimum cost for weights lesser than w--use previous calculated cost to evsluate next dp element
To control -1 for no packet make it's cost very big(out of output from constraint), so that using this min price will bevery high(if this will be output , output -1

TC - O(w^2), SC - O(w)
*/

import java.util.Arrays;

public class June_15{
    public int minimumCost(int[] cost, int w) {
        int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int weight = 1; weight <= w; weight++) {
            for (int packet = 1; packet <= cost.length; packet++) {
                if (cost[packet - 1] == -1) continue;
                if (packet > weight) break;
                dp[weight] = Math.min(dp[weight],dp[weight - packet] + cost[packet - 1]);
            }
        }
        return dp[w] >= INF ? -1 : dp[w];
    }
}