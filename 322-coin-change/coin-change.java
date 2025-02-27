class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0 || dp[i - coins[j]] == -1) {
                    continue;
                }
                if(i == coins[j]) {
                    minCount = 1;
                }
                minCount = Math.min(dp[i - coins[j]] + 1, minCount);
            }
            dp[i] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        }

        return dp[amount];
    }
}
