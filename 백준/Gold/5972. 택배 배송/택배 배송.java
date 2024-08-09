import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Node {
        public int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] lists = new ArrayList[N+1];

        for (int i = 0; i <= N; i++)
            lists[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            lists[A].add(new Node(B, C));
            lists[B].add(new Node(A, C));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[1] = 0;
        nodes.add(new Node(1, 0));

        while (!nodes.isEmpty()) {
            Node now = nodes.poll();

            if(now.cost > dist[now.dest])
                continue;

            for (Node next : lists[now.dest]) {
                if(dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    nodes.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        System.out.println(dist[N]);
    }
}