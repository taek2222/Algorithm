import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int V;
    static Map<Integer, List<Node>> nodes;
    static boolean[] visit;
    static int max;
    static int lastNode;

    static class Node {
        private int end;
        private int value;

        public Node(final int end, final int value) {
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        nodes = new HashMap<>();
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                List<Node> values = nodes.getOrDefault(start, new ArrayList<>());
                values.add(new Node(end, value));
                nodes.put(start, values);
            }
        }

        max = 0;
        visit = new boolean[V + 1];
        dfs(1, 0);

        visit = new boolean[V + 1];
        dfs(lastNode, 0);

        System.out.println(max);
    }

    private static void dfs(int pos, int len) {
        if (max < len) {
            lastNode = pos;
            max = len;
        }

        visit[pos] = true;
        List<Node> nodeList = nodes.get(pos);
        for (Node node : nodeList) {
            if (visit[node.end]) {
                continue;
            }
            dfs(node.end, len + node.value);
        }
    }
}
