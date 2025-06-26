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

    static int[] distances;
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        distances = new int[n + 1];

        bus = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            int[] value = bus.getOrDefault(start, new int[n + 1]);
            value[target] = cost;
            bus.put(start, value);
        }

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            bfs(i, new boolean[n + 1], x, n);
        }

        int answer = 0;
        for (int distance : distances) {
            answer = Math.max(distance, answer);
        }

        System.out.println(answer);
    }

    private static void bfs(int start, boolean[] visit, int pos, int n) {
        PriorityQueue<Node> deque = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        deque.add(new Node(start, 0));

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            visit[node.target] = true;

            int[] value = bus.getOrDefault(node.target, new int[]{});
            if (node.target == pos) {
                visit = new boolean[n + 1];
                visit[pos] = true;
                deque.clear();
            }

            if (node.target == start && node.cost != 0) {
                distances[start] = node.cost;
                return;
            }

            for (int i = 1; i < value.length; i++) {
                if (value[i] != 0 && !visit[i]) {
                    deque.add(new Node(i, node.cost + value[i]));
                }
            }
        }
    }
}
