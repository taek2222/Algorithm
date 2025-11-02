import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int pos;
        int weight;

        public Node(final int pos, final int weight) {
            this.pos = pos;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> loads = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            loads.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visit = new boolean[100 + 1];
        visit[1] = true;

        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(1, 0));

        while (!deque.isEmpty()) {
            Node current = deque.poll();

            for (int i = 1; i <= 6; i++) {
                int nextPos = current.pos + i;

                if (nextPos == 100) {
                    System.out.println(current.weight + 1);
                    return;
                }

                if (visit[nextPos]) {
                    continue;
                }

                if (loads.containsKey(nextPos)) {
                    nextPos = loads.get(nextPos);
                }

                visit[nextPos] = true;
                deque.add(new Node(nextPos, current.weight + 1));
            }
        }

        System.out.println(0);
    }
}
