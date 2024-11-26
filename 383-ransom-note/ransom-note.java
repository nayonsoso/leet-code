class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            alphabet[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            alphabet[idx]--;
            if (alphabet[idx] < 0) {
                return false;
            }
        }

        return true;
    }
}
