class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // 1 base
        Arrays.fill(dp, false);

        dp[0] = true; // if prefix is blank, we can skip prefix condition
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {

                int prefixSize = i - word.length();
                if (prefixSize < 0) {
                    continue;
                }

                dp[i] = dp[prefixSize] && s.substring(prefixSize, i).equals(word);
                if (dp[i]) { // prevent over write
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
