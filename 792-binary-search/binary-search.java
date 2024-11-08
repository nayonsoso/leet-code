class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (end + start) / 2;

        while (end > start) {
            System.out.println("s: " + start + ", m:" + middle + ", e: " + end);
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                return middle;
            }
            middle = (end + start) / 2;
        }

        if (end < 0 || start > nums.length - 1) {
            return -1;
        }

        if (nums[end] == target) {
            return middle;
        }

        return -1;
    }
}
