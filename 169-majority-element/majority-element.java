class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq + 1);
        }

        int threshold = nums.length / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > threshold) {
                return key;
            }
        }
        return Integer.MIN_VALUE;
    }
}