class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bs1(matrix, target);
        if(row == -1) {
            return false;
        }

        int col = bs2(matrix[row], target);
        if(col == -1) {
            return false;
        }

        return matrix[row][col] == target;
    }


  private static int bs1(int[][] matrix, int target) {
    int left = -1;
    int right = matrix.length;

    while (left + 1 < right) {
      int middle = left + (right - left) / 2;
      if (target >= matrix[middle][0]) { 
        left = middle; 
      } else {
        right = middle; 
      }
    }

    return left;
  }

  private static int bs2(int[] arr, int target) {
    int left = -1;
    int right = arr.length; 

    while (left + 1 < right) {
      int middle = left + (right - left) / 2;
      if (target >= arr[middle]) {
        left = middle;
      } else {
        right = middle;
      }
    }

    return left;
  }
}