class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                candidate = nums[i];
            }
            freq += candidate == nums[i] ? 1 : -1;
        }

        return candidate;
    }
}