class Solution {
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0L;
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

        // pointer : inclusive
        int left = -1;
        int right = n;

        for (int i = 0; i < k; i++) {
            // 항상 후보의 수만큼을 가지고 있으려 하지만, left와 right가 같으면 더 이상 넣지 않는다.
            // 처음 초기화하고 시작하는게 아니라, for 문에서 넣어주면 헷갈림을 더욱 줄일 수 있다.
            while (leftPQ.size() < candidates && left + 1< right) {
                leftPQ.offer(costs[++left]);
            }
            while (rightPQ.size() < candidates && left + 1< right) {
                rightPQ.offer(costs[--right]);
            }

            // 분배가 다 되었다고 생각하면, 이후의 작업이 더 쉬워진다.
            if (leftPQ.isEmpty()) {
                total += rightPQ.poll();
            } else if (rightPQ.isEmpty()) {
                total += leftPQ.poll();
            } else if (leftPQ.peek() <= rightPQ.peek()) { // 최소값이 작다면, leftPQ에서 없애기
                total += leftPQ.poll();
            } else {
                total += rightPQ.poll();
            }
        }

        return total;
    }
}