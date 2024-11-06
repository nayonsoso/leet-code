class Solution {

    public boolean isPalindrome(String s) {
        String lowercases = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(!isAlphanumeric(lowercases.charAt(left))) {
                left++;
                continue;
            }
            if(!isAlphanumeric(lowercases.charAt(right))) {
                right--;
                continue;
            }
            if(lowercases.charAt(left) != lowercases.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isAlphanumeric(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
