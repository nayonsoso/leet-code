class Solution {
public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;
        
        // 최소 힙 (우선순위 큐)
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0;  // 왼쪽 포인터
        int right = n - 1; // 오른쪽 포인터

        // 앞쪽 candidates명을 최소 힙에 삽입
        while (left < candidates) {
            leftHeap.offer(costs[left++]);
        }
        
        // 뒤쪽 candidates명을 최소 힙에 삽입 (겹치지 않는 경우만)
        while (right >= Math.max(left, n - candidates)) {
            rightHeap.offer(costs[right--]);
        }

        // k명 고용
        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll(); // 왼쪽에서 최소 비용 선택
                
                // 새로운 후보 추가
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                totalCost += rightHeap.poll(); // 오른쪽에서 최소 비용 선택
                
                // 새로운 후보 추가
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return totalCost;
    }
}