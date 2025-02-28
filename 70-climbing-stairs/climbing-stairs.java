class Solution {
    public int climbStairs(int stairCount) {
        if (stairCount == 1) {
            return 1;
        }

        int[] dp = new int[stairCount + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stairCount; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[stairCount];
    }
}
