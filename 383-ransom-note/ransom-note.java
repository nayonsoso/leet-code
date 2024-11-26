class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (char letter : magazine.toCharArray()) {
            alphabet[letter - 'a']++;
        }

        for (char letter : ransomNote.toCharArray()) {
            int idx = letter - 'a';
            alphabet[idx]--;
            if (alphabet[idx] < 0) {
                return false;
            }
        }

        return true;
    }
}