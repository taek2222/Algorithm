import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {

    static char[][] resistance;
    static boolean[][] visit;
    static int[] directionX = new int[]{1, -1, 0, 0};
    static int[] directionY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        resistance = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                resistance[i][j] = line.charAt(j);
            }
        }

        visit = new boolean[N][N];
        int total = 0;
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] || resistance[i][j] == '0') {
                    continue;
                }

                visit[i][j] = true;
                total++;
                answers.add(dfs(i, j, 1));
            }
        }

        Collections.sort(answers);

        System.out.println(total);
        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }

    private static int dfs(int x, int y, int count) {
        for (int i = 0; i < directionX.length; i++) {
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];

            if (nextX < 0 || nextY < 0 || nextX >= resistance.length || nextY >= resistance.length
                    || visit[nextX][nextY] || resistance[nextX][nextY] == '0') {
                continue;
            }

            visit[nextX][nextY] = true;
            count++;
            count = dfs(nextX, nextY, count);
        }
        return count;
    }
}
