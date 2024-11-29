class Solution {
    public String addBinary(String a, String b) {
        return Solution.addBinary1(a,b);
    }

    static String addBinary1(String a, String b) {
        String[] preprocessed = makeLengthSame(a, b);
        String a_ = preprocessed[0];
        System.out.println(a_);
        String b_ = preprocessed[1];
        System.out.println(b_);

        int idx = a_.length() - 1;

        boolean carry = false;
        char[] result = new char[idx + 1];
        while (idx >= 0) {
            int sum = (a_.charAt(idx) - '0') + (b_.charAt(idx) - '0');
            if (carry) {
                sum++;
            }

            System.out.println(sum);

            if (sum > 1) {
                carry = true;
                result[idx] = sum == 2 ? '0' : '1';
            } else {
                carry = false;
                result[idx] = (char) (sum + '0');
            }
            idx--;
        }

        if (result[0] == '0') {
            String answer = "";
            for (int i = 1; i < result.length; i++) {
                answer += result[i];
            }
            return answer;
        }
        return new String(result);
    }

    static String[] makeLengthSame(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String[] result = new String[2];
        if (aLength > bLength) {
            result[0] = "0" + a;
            result[1] = "0".repeat(aLength - bLength + 1) + b;
        } else {
            result[0] = "0".repeat(bLength - aLength + 1) + a;
            result[1] = "0" + b; // 011
        }
        return result;
    }
}