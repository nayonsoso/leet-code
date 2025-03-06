class Solution {
    public int findKthLargest(int[] arr, int k) {
        Integer[] sorted = new Integer[arr.length];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted, (a, b) -> (b - a));
        return sorted[k - 1];
    }
}