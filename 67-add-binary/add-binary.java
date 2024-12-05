class Solution {
    public String addBinary(String a, String b) {
        return Solution.addBinary1(a, b);
    }

    static String addBinary1(String a, String b) {
        if (a.length() > b.length()) {
            b = "0".repeat(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            a = "0".repeat(b.length() - a.length()) + a;
        }

        int idx = a.length() - 1;
        boolean carry = false;
        StringBuilder answer = new StringBuilder();
        while (idx >= 0) {
            int tmp = (a.charAt(idx) - '0') + (b.charAt(idx) - '0');
            tmp += carry ? 1 : 0; 
            answer.append(tmp == 2 || tmp == 0 ? "0" : "1");
            carry = (tmp >= 2 ? true : false);
            idx--;
        }
        if (carry) {
            answer.append("1");
        }
        answer.reverse();

        return answer.toString();
    }
}
