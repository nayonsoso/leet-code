class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        return Solution.findFirstOrLastIdx(nums, target);
    }

    private static int[] findFirstOrLastIdx(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] answer = new int[2];

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target < nums[middle]) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                answer[0] = Solution.findFirstIdx(nums, middle);
                answer[1] = Solution.findLastIdx(nums, middle);
                return answer;
            }
        }

        return new int[] { -1, -1 };
    }

    private static int findFirstIdx(int[] nums, int any) {
        int start = -1;
        int end = any + 1;
        int target = nums[any];

        while (start + 1 < end) {
            int middle = (start + end) / 2;
            if (nums[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        return end;
    }

    private static int findLastIdx(int[] nums, int any) {
        int start = any - 1;
        int end = nums.length;
        int target = nums[any];

        while (start + 1 < end) {
            int middle = (start + end) / 2;
            if (target < nums[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return start;
    }
}
