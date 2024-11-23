class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { -1, -1 };
        return findFirstIdx(nums, target);
    }

  private int[] findFirstIdx(int[] nums, int target) {
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
        int tmp = middle;
        // first index
        while (true) {
          if (tmp == 0 || nums[tmp - 1] != target) {
            answer[0] = tmp;
            break;
          }
          tmp--;
        }

        // last index
        while(true) {
          if (middle == nums.length -1 || nums[middle + 1] != target) {
            answer[1] = middle;
            break;
          }
          middle++;
        }

        return answer;
      }
    }
    
    return new int[] { -1, -1 };
  }
}
