class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        recursive(image, sr, sc, color, original);
        return image;
    }

    void recursive(int[][] image, int x, int y, int color, int original) {
        if (isOutside(image, x, y)) {
            return;
        }
        if(image[x][y] == color) {
            return;
        }
        if (original == image[x][y]) {
            image[x][y] = color;
        } else {
            return;
        }

        recursive(image, x+1, y, color, original);
        recursive(image, x-1, y, color, original);
        recursive(image, x, y+1, color, original);
        recursive(image, x, y-1, color, original);
    }

    boolean isOutside(int[][] matrix, int x, int y) {
        return (x < 0 || x > matrix.length -1 || y < 0 || y > matrix[0].length -1);
    }
}
