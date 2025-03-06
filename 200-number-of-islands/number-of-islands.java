class Solution {

    public int numIslands(char[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int count = 0;
        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == '1') {
                    count++;
                    dfs(arr, row, col, direction, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] arr, int row, int col, int[][] direction, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || arr[x][y] == '0') {
            return;
        }

        arr[x][y] = '0';
        for (int[] dir : direction) {
            dfs(arr, row, col, direction, x + dir[0], y + dir[1]);
        }
    }
}