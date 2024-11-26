class Solution {
    public int longestPalindrome(String s) {
        return Solution.findLongestPalindromeLength(s);
    }

    static int findLongestPalindromeLength(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            int val = map.getOrDefault(key, 0);
            map.put(key, val + 1);
        }

        int answer = 0;
        boolean isOdd = false;
        for (char k : map.keySet()) {
            int frequency = map.get(k);
            if (frequency % 2 == 0) {
                answer += frequency;
            } else {
                answer += frequency - 1;
                isOdd = true;
            }
        }

        if (isOdd) {
            return answer + 1;
        }
        return answer;
    }
}
