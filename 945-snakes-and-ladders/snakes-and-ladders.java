class Solution {

    class Node {
        int position;
        int count;

        Node(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int[] arr = flattenMatrix(board);
        int answer = solve(arr);
        return answer;
    }

    public int solve(int[] arr) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        int n = arr.length - 1;

        // add start at queue
        int start = 1;
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.position == n) {
                return now.count;
            }

            for (int i = 1; i <= 6; i++) { // rolling dice once
                int nextPosition = now.position + i;
                if (nextPosition > n) {
                    continue;
                }

                if (arr[nextPosition] != nextPosition) {
                    nextPosition = arr[nextPosition];
                }

                if (!visited[nextPosition]) {
                    queue.add(new Node(nextPosition, now.count + 1));
                    visited[nextPosition] = true;
                }
            }
        }

        return -1;
    }

    int[] flattenMatrix(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1]; // value at board is one-base counting
        int idx = 1;

        int direction = 1;
        for (int i = n - 1; i >= 0; i--) {
            int j = (direction == 1) ? 0 : n - 1;
            for (int k = 0; k < n; k++) {
                if (board[i][j] == -1) {
                    arr[idx] = idx;
                } else {
                    arr[idx] = board[i][j];
                }
                j += direction;
                idx++;
            }
            direction *= -1;
        }
        return arr;
    }
}