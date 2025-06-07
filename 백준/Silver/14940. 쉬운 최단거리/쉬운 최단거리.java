import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {

    static int[] directionX = new int[]{1, -1, 0, 0};
    static int[] directionY = new int[]{0, 0, 1, -1};

    static class Pos {
        private final int x;
        private final int y;
        private final int score;

        public Pos(final int x, final int y, final int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Pos pos = (Pos) o;
            return x == pos.x && y == pos.y && score == pos.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, score);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Pos> deque = new ArrayDeque<>();
        int[][] land = new int[n][m];
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], -1);
        }

        // 판 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                if (land[i][j] == 2) { // 첫 번째 도착 지점
                    Pos pos = new Pos(i, j, 0);
                    deque.add(pos);
                }
                if (land[i][j] == 0) {
                    answer[i][j] = 0;
                }
            }
        }

        // bfs
        while (!deque.isEmpty()) {
            Pos currentPos = deque.pop();
            answer[currentPos.x][currentPos.y] = currentPos.score;

            for (int i = 0; i < directionX.length; i++) {
                int nextX = currentPos.x + directionX[i];
                int nextY = currentPos.y + directionY[i];
                int nextScore = currentPos.score + 1;

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) { // 올바른 좌표가 아닌 경우
                    continue;
                }

                if (land[nextX][nextY] != 1) { // 이동 가능한 곧이 아닌 경우
                    continue;
                }

                if (answer[nextX][nextY] <= nextScore && answer[nextX][nextY] != -1) {
                    continue;
                }

                Pos nextPos = new Pos(nextX, nextY, nextScore);
                if (!deque.contains(nextPos)) {
                    deque.add(nextPos);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
