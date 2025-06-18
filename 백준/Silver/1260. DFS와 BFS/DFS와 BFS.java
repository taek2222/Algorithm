import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    static Map<Integer, TreeSet<Integer>> nodes;
    static BufferedWriter bw;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        nodes = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            nodes.put(i, new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            insert(v1, v2);
            insert(v2, v1);
        }

        visit = new boolean[1001];
        visit[V] = true;
        dfs(V);

        bw.append("\n");

        visit = new boolean[1001];
        visit[V] = true;
        bfs(V);

        bw.flush();
    }

    private static void dfs(int pos) throws IOException {
        bw.append(String.valueOf(pos)).append(" ");

        TreeSet<Integer> treeSet = nodes.get(pos);
        for (int node : treeSet) {
            if (visit[node]) {
                continue;
            }

            visit[node] = true;
            dfs(node);
        }
    }

    private static void bfs(int start) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            Integer key = deque.pop();
            bw.append(String.valueOf(key)).append(" ");
            TreeSet<Integer> treeSet = nodes.get(key);

            for (int node : treeSet) {
                if (visit[node]) {
                    continue;
                }

                visit[node] = true;
                deque.add(node);
            }
        }
    }

    private static void insert(final int v1, final int v2) {
        TreeSet<Integer> value = nodes.get(v1);
        value.add(v2);
        nodes.put(v1, value);
    }
}
