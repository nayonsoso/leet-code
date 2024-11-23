class Solution {
    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;

        while(l + 1 < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                return m;
            }
        }

        return -1;
    }
}

// sorted in ascending order
// if target exist, return target's idx
// if not, return -1