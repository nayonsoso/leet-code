class Solution {
    public boolean isPalindrome(String s) {

        String lowercases = s.toLowerCase();
        System.out.print(lowercases);
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(isAlphabet(lowercases.charAt(i))) {
                deque.addLast(lowercases.charAt(i));
            }
        }

        while(deque.size() > 1) { 
            char head = deque.removeFirst();
            char tail = deque.removeLast();
            if (head != tail) {
                return false;
            }
        }
        return true;
    }

    boolean isAlphabet(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
