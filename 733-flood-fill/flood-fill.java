class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        recursive(image, sr, sc, color, original);
        return image;
    }

    void recursive(int[][] image, int x, int y, int color, int original) {
        // isOutSide
        if (x < 0 || x > image.length -1 || y < 0 || y > image[0].length -1) {
            return;
        }
        
        // is already colored
        // is same color as firstColor
        if(image[x][y] == color || original != image[x][y]) {
            return;
        }
        
        image[x][y] = color;

        recursive(image, x+1, y, color, original);
        recursive(image, x-1, y, color, original);
        recursive(image, x, y+1, color, original);
        recursive(image, x, y-1, color, original);
    }
}
