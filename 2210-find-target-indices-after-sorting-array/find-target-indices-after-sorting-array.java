class Solution {

    List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();

        int l = findLeftIdx(nums, target);
        int r = findRightIdx(nums, target);
        if (l == -1 || r == -1) {
            return List.of();
        }

        for (int i = l; i <= r; i++) {
            answer.add(i);
        }
        return answer;
    }

    int findLeftIdx(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (target <= nums[m]) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            }
        }
        if (r == 0 && target != nums[0]) {
            return -1;
        }
        return r;
    }

    int findRightIdx(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (target < nums[m]) {
                r = m;
            } else if (nums[m] <= target) {
                l = m;
            }
        }
        if (l == nums.length - 1 && nums[l] != target) {
            return -1;
        }
        return l;
    }
}
