import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static boolean[][] cabbage;
    static boolean[][] mark;
    static int M;
    static int N;
    static List<int[]> directions = List.of(
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 1. 판 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            mark = new boolean[M][N];
            cabbage = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                cabbage[X][Y] = true;
            }

            int result = 0;
            for (int j = 0; j < cabbage.length; j++) {
                for (int k = 0; k < cabbage[0].length; k++) {
                    if (cabbage[j][k] && !mark[j][k]) { // 배추 심어져 있고, 마크가 없는 곳
                        result++;
                        research(j, k);
                    }
                }
            }
            bw.append(String.valueOf(result)).append("\n");
        }
        bw.flush();
    }

    private static void research(int x, int y) {
        mark[x][y] = true;
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || !cabbage[nextX][nextY] || mark[nextX][nextY]) {
                continue;
            }
            research(nextX, nextY);
        }
    }
}