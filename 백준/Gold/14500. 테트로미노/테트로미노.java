import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visit;
    static int[][] graph;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int maxValue = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, graph[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(1, i, j, graph[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int depth, int x, int y, int score) {
        if (depth == 4) {
            answer = Math.max(answer, score);
            return;
        }

        if (score + (4 - depth) * maxValue <= answer) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length || visit[nx][ny]) {
                continue;
            }

            visit[nx][ny] = true;
            if (depth == 2) {
                dfs(depth + 1, x, y, score + graph[nx][ny]);
            }

            dfs(depth + 1, nx, ny, score + graph[nx][ny]);
            visit[nx][ny] = false;
        }
    }
}
