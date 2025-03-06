class Solution {
    public int majorityElement(int[] nums) { // [3]

        // checked the element
        int count = 0;
        int recentNum = nums[0]; // 3

        for (int i = 1; i < nums.length; i++) { // 2
            if (nums[i] == recentNum) { // 3 != 2
                count++;
            } else {
                if (count - 1 < 0) { // -1
                    recentNum = nums[i]; // recentNum = 3;
                    count = 0; // count = 0;
                } else {
                    count--;
                }
            }
        }

        return recentNum; // 3
    }
}
