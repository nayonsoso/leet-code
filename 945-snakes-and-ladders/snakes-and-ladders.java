class Solution {

    public int snakesAndLadders(int[][] board) {
        int[] arr = flattenMatrix(board);
        int answer = solve(arr);
        return answer;
    }

    public int solve(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        int end = arr.length - 1;

        int start = 1;
        queue.add(start);
        visited[start] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int now = queue.poll();
                if (now == end) {
                    return moves;
                }

                for (int i = 1; i <= 6; i++) {
                    int nextPosition = now + i;
                    if (nextPosition > end) {
                        continue;
                    }

                    if (arr[nextPosition] != nextPosition) {
                        nextPosition = arr[nextPosition];
                    }

                    if (!visited[nextPosition]) {
                        queue.add(nextPosition);
                        visited[nextPosition] = true;
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    int[] flattenMatrix(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];

        int idx = 1;
        int direction = 1;

        for (int i = n - 1; i >= 0; i--) {
            int j = (direction == 1) ? 0 : n - 1;
            for (int k = 0; k < n; k++) {
                arr[idx] = (board[i][j] == -1) ? idx : board[i][j];
                j += direction;
                idx++;
            }
            direction *= -1;
        }
        return arr;
    }
}