class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> graph = makeGraph(times);
        int[] d = dijkstra(graph, k, n);
        int answer = findMax(d);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }

    Map<Integer, List<Node>> makeGraph(int[][] matrix) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            int w = matrix[i][2];
            graph.putIfAbsent(u, new LinkedList<>());
            graph.get(u).add(new Node(v, w));
        }
        return graph;
    }

    int[] dijkstra(Map<Integer, List<Node>> graph, int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (graph.get(now.value) == null) {
                continue;
            }
            for (Node next : graph.get(now.value)) {
                if (distance[now.value] + next.time < distance[next.value]) {
                    distance[next.value] = distance[now.value] + next.time;
                    pq.add(new Node(next.value, distance[next.value]));
                }
            }
        }

        return distance;
    }

    int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    class Node {
        int value;
        int time;

        Node(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}
