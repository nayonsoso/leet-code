class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = { -1, -1 };
        if (nums.length == 0) {
            return answer;
        }

        int anyIdx = findAnyIdx(nums, target);
        if (anyIdx == -1) {
            return answer;
        }

        answer[0] = findStartIdx(nums, anyIdx);
        answer[1] = findLastIdx(nums, anyIdx);
        return answer;
    }

    int findAnyIdx(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    int findStartIdx(int[] nums, int anyIdx) {
        int start = 0;
        int end = anyIdx;

        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] == nums[anyIdx]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    int findLastIdx(int[] nums, int anyIdx) {
        int start = anyIdx;
        int end = nums.length - 1;

        while (start < end) {
            int middle = (start + end + 1) / 2;
            if (nums[middle] == nums[anyIdx]) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }
}
