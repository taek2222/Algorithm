import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            friends.get(f1).add(f2);
            friends.get(f2).add(f1);
        }

        int answer = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int kevinBacon = bfs(N, i, friends);
            if (minSum > kevinBacon) {
                minSum = kevinBacon;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(final int N, final int start, final List<List<Integer>> friends) {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        visit[start] = true;
        while (!deque.isEmpty()) {
            int current = deque.pop();

            for (int nextPosition : friends.get(current)) {
                if (visit[nextPosition]) {
                    continue;
                }

                visit[nextPosition] = true;
                dist[nextPosition] = dist[current] + 1;
                deque.add(nextPosition);
            }
        }

        int total = 0;
        for (int distance : dist) {
            total += distance;
        }
        return total;
    }
}
