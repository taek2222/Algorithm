import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static class Node {
        private int pos;
        private int time;

        public Node(final int pos, final int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100_101];
        Deque<Node> deque = new ArrayDeque<>();
        visit[N] = true;
        deque.add(new Node(N, 0));

        int answer = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            Node current = deque.pop();
            visit[current.pos] = true;

            if (current.pos == K) {
                answer = Math.min(answer, current.time);
            }

            if (current.pos < K && current.pos * 2 < 100_101 && !visit[current.pos * 2]) {
                deque.add(new Node(current.pos * 2, current.time));
            }

            if (current.pos < K && current.pos + 1 < 100_101 && !visit[current.pos + 1]) {
                deque.add(new Node(current.pos + 1, current.time + 1));
            }

            if (current.pos - 1 >= 0 && !visit[current.pos - 1]) {
                deque.add(new Node(current.pos - 1, current.time + 1));
            }
        }

        System.out.println(answer);
    }
}
