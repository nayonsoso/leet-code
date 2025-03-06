class Solution {
    public long totalCost(int[] costs, int sessions, int candidates) {
        PriorityQueue<Integer> leftCosts = new PriorityQueue<>();
        PriorityQueue<Integer> rightCosts = new PriorityQueue<>();

        int left = 0;
        while (left < candidates) {
            leftCosts.offer(costs[left++]);
        }

        int right = costs.length - 1;
        while (right >= Math.max(left, costs.length - candidates)) {
            rightCosts.offer(costs[right--]);
        }

        long totalCost = 0;
        for (int i = 0; i < sessions; i++) {
            int currentCost;

            if (!rightCosts.isEmpty() && !leftCosts.isEmpty()) {
                int minLeft = leftCosts.peek();
                int minRight = rightCosts.peek();
                currentCost = Math.min(minLeft, minRight);

                if (minLeft <= minRight) {
                    leftCosts.poll();
                    if (left <= right) {
                        leftCosts.offer(costs[left++]);
                    }
                } else {
                    rightCosts.poll();
                    if (left <= right) {
                        rightCosts.offer(costs[right--]);
                    }
                }
            } else if (rightCosts.isEmpty()) {
                currentCost = leftCosts.peek();
                leftCosts.poll();
            } else {
                currentCost = rightCosts.peek();
                rightCosts.poll();
            }

            totalCost += currentCost;
        }

        return totalCost;
    }
}