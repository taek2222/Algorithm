import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static char[][] campus;
    static boolean[][] visit;
    static int[] directionX = new int[]{1, -1, 0, 0};
    static int[] directionY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        int[] startPos = new int[2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }

        visit = new boolean[N][M];
        visit[startPos[0]][startPos[1]] = true;

        int answer = bfs(startPos, N, M);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int[] doYeonPos, int N, int M) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(doYeonPos);

        int answer = 0;
        while (!deque.isEmpty()) {
            int[] pos = deque.pop();

            if (campus[pos[0]][pos[1]] == 'P') {
                answer++;
            }

            for (int i = 0; i < directionX.length; i++) {
                int nextX = pos[0] + directionX[i];
                int nextY = pos[1] + directionY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visit[nextX][nextY]
                        || campus[nextX][nextY] == 'X') {
                    continue;
                }

                visit[nextX][nextY] = true;
                deque.add(new int[]{nextX, nextY});
            }
        }

        return answer;
    }
}
