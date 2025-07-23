import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static class Node {
        private int next;
        private int count;

        public Node(final int next, final int count) {
            this.next = next;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startHuman = Integer.parseInt(st.nextToken());
        int endHuman = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Integer>> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ArrayList<Integer> value = nodes.get(x);
            value.add(y);
            nodes.put(x, value);

            value = nodes.get(y);
            value.add(x);
            nodes.put(y, value);
        }

        boolean[] visit = new boolean[n + 1];
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(startHuman, 0));

        int answer = -1;
        while (!deque.isEmpty()) {
            Node node = deque.pop();

            if (node.next == endHuman) {
                answer = node.count;
                break;
            }

            visit[node.next] = true;
            ArrayList<Integer> values = nodes.get(node.next);
            for (int value : values) {
                if (visit[value]) {
                    continue;
                }
                Node newNode = new Node(value, node.count + 1);
                deque.push(newNode);
            }
        }

        System.out.println(answer);
    }
}
