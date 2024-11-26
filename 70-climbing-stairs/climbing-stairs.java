class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        int third = 0;

        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // 1, 2, 3, 5, 8, 13
        for(int i = 0; i < n-2 ; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
