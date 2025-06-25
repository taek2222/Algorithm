import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int[][] answer;
    static Map<Integer, int[]> bus;

    static class Node {
        private int target;
        private int cost;

        public Node(final int target, final int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Node node = (Node) o;
            return target == node.target;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        answer = new int[n + 1][n + 1];

        bus = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            int[] value = bus.getOrDefault(start, new int[n + 1]);
            if (value[target] != 0) {
                value[target] = Math.min(value[target], cost);
            } else {
                value[target] = cost;
            }

            bus.put(start, value);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i, new boolean[n + 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int start, boolean[] visit) {
        PriorityQueue<Node> deque = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        deque.add(new Node(start, 0));

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            visit[node.target] = true;
            if (answer[start][node.target] != 0) {
                answer[start][node.target] = Integer.min(node.cost, answer[start][node.target]);
            } else {
                answer[start][node.target] = node.cost;
            }

            int[] value = bus.getOrDefault(node.target, new int[]{});
            for (int i = 1; i < value.length; i++) {
                if (value[i] != 0 && !visit[i]) {
                    deque.add(new Node(i, node.cost + value[i]));
                }
            }
        }
    }
}
