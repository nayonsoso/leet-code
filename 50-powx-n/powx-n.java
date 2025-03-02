class Solution {
    public static double myPow(double x, int n) {
        if (n < 0) {
            return 1 / positivePow(x, -n);
        }
        return positivePow(x, n);
    }

    private static double positivePow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double halfPower = positivePow(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        }
        return halfPower * halfPower * x;
    }
}