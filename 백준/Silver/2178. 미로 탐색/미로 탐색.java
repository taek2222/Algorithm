import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static char[][] positions;
    static boolean[][] visit;
    static int[] directionX = new int[]{1, -1, 0, 0};
    static int[] directionY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        positions = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                positions[i][j] = line.charAt(j);
            }
        }

        System.out.println(bfs(N, M));
    }

    private static int bfs(int N, int M) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 1}); // x, y, 이동 거리
        visit[0][0] = true;

        while (!deque.isEmpty()) {
            int[] info = deque.pop();

            for (int i = 0; i < directionX.length; i++) {
                int nextX = info[0] + directionX[i];
                int nextY = info[1] + directionY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visit[nextX][nextY]
                        || positions[nextX][nextY] == '0') {
                    continue;
                }

                if (nextX == N - 1 && nextY == M - 1) {
                    return info[2] + 1;
                }

                visit[nextX][nextY] = true;
                deque.add(new int[]{nextX, nextY, info[2] + 1});
            }
        }

        return 0;
    }
}
