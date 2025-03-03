class Solution {
    public int[] searchRange(int[] arr, int target) {
        int firstPosition = getLeftBound(arr, target) + 1;
        int lastPosition = getLeftBound(arr, target + 1);
        if (firstPosition < arr.length && arr[firstPosition] == target) {
            return new int[] { firstPosition , lastPosition };
        }
        return new int[] { -1, -1 };
    }

    private static int getLeftBound(int[] arr, int target) {
        int left = -1;
        int right = arr.length;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid;
            } else if (arr[mid] >= target) {
                right = mid;
            }
        }

        return left;
    }
}