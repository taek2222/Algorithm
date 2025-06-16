import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    private static final int MAX_POS = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[MAX_POS + 1];
        Deque<Integer> bfs = new ArrayDeque<>();
        bfs.add(K);

        int nextPos;
        int answer = -1;

        while (!bfs.isEmpty()) {

            int currentSize = bfs.size();
            for (int i = 0; i < currentSize; i++) {
                int pos = bfs.pop();

                if (pos == N) {
                    bfs.clear();
                    break;
                }

                if (pos % 2 == 0) {
                    nextPos = pos / 2;
                    if (!visit[nextPos] && nextPos != pos) {
                        visit[nextPos] = true;
                        bfs.add(nextPos);
                    }

                    nextPos = pos - 1;
                    if (nextPos >= 0 && !visit[nextPos]) {
                        visit[nextPos] = true;
                        bfs.add(nextPos);
                    }

                    nextPos = pos + 1;
                    if (nextPos <= MAX_POS && !visit[nextPos]) {
                        visit[nextPos] = true;
                        bfs.add(nextPos);
                    }
                }

                if (pos % 2 == 1) {
                    nextPos = pos - 1;
                    if (!visit[nextPos]) {
                        visit[nextPos] = true;
                        bfs.add(nextPos);
                    }

                    nextPos = pos + 1;
                    if (nextPos <= MAX_POS && !visit[nextPos]) {
                        visit[nextPos] = true;
                        bfs.add(nextPos);
                    }
                }
            }

            answer++;
        }
        System.out.println(answer);
    }
}
