class Solution {

    final int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][] grid;

    int orangesRotting(int[][] t) {
        grid = t;
        if (!checkFreshOrangeExists()) {
            return 0;
        }

        Queue<int[]> queue = saveRottenOranges();
        int time = makeOrangesRotten(queue);

        if (checkFreshOrangeExists()) {
            return -1;
        }

        return time;
    }

    boolean checkFreshOrangeExists() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    Queue<int[]> saveRottenOranges() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        return queue;
    }

    int makeOrangesRotten(Queue<int[]> queue) {
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFreshAppeard = false;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextR = now[0] + dir[j][0];
                    int nextC = now[1] + dir[j][1];
                    if (nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length) {
                        continue;
                    }

                    int[] next = new int[] { nextR, nextC };
                    if (grid[nextR][nextC] == 1) {
                        queue.add(next);
                        grid[nextR][nextC] = 2;
                        isFreshAppeard = true;
                    }
                }
            }
            if (isFreshAppeard) {
                moves++;
            }
        }

        return moves;
    }
}