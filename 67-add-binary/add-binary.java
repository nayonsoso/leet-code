class Solution {
    public String addBinary(String a, String b) {
        return Solution.addBinary1(a, b);
    }

    static String addBinary1(String a, String b) {
        boolean[][] preprocessed = makeLengthSame(a, b);
        boolean[] a_ = preprocessed[0];
        boolean[] b_ = preprocessed[1];

        int idx = a_.length - 1;

        boolean carry = false;
        boolean[] result = new boolean[idx + 2];
        while (idx >= 0) {
            if (a_[idx] == b_[idx]) {
                result[idx + 1] = carry;
                carry = a_[idx];
            } else if (a_[idx] != b_[idx]) {
                result[idx + 1] = !carry;
            }
            idx--;
        }
        result[0] = carry;

        StringBuilder answer = new StringBuilder();
        int boundary = 0;
        if (!result[0]) {
            boundary = 1;
        }
        System.out.print(boundary);
        System.out.print(result.length);
        for (int i = boundary; i < result.length; i++) {
            answer.append(result[i] ? "1" : "0");
        }
        return answer.toString();
    }

    static boolean[][] makeLengthSame(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength, bLength);

        boolean[][] result = new boolean[2][maxLength];
        if (aLength > bLength) {
            for (int i = 0; i < aLength; i++) {
                result[0][i] = (a.charAt(i) == '0' ? false : true);
            }
            for (int i = 0; i < bLength; i++) {
                result[1][aLength - bLength + i] = (b.charAt(i) == '0' ? false : true);
            }
        } else {
            for (int i = 0; i < aLength; i++) {
                result[0][bLength - aLength + i] = (a.charAt(i) == '0' ? false : true);
            }
            for (int i = 0; i < bLength; i++) {
                result[1][i] = (b.charAt(i) == '0' ? false : true);
            }
        }
        return result;
    }
}
