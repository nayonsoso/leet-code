class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            int[] idxNotFound = { -1, -1 };
            return idxNotFound;
        }

        int anyIdx = findAnyIdx(nums, target);
        if (anyIdx == -1) {
            int[] idxNotFound = { -1, -1 };
            return idxNotFound;
        } else {
            int[] answer = new int[2];
            answer[0] = findStartIdx(nums, anyIdx);
            answer[1] = findLastIdx(nums, anyIdx);
            return answer;
        }
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

        while (start < end) { // start:0 end:1
            int middle = (start + end + 1) / 2; // middle: 1
            System.out.println("start:" + start + "(" + nums[start]+ 
            "), end:" + end + "(" + nums[end] + "), middle:" + middle + "(" + nums[middle] + ")");
            if (nums[middle] == nums[anyIdx]) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }
}
