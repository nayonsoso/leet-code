class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;
        int lastTrue = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                int newLastTrue = lastTrue;
                for (int j = lastTrue + 1; j <= i + arr[i] && j < n; j++) {
                    dp[j] = true;
                    newLastTrue = j;
                }
                lastTrue = newLastTrue;
            }
        }
        return dp[n - 1];
    }
}