import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] round = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int total = 0;
            for (int j = 0; j < M; j++) {
                total += Integer.parseInt(st.nextToken());
                round[i][j] = total;
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total = 0;
            for (int j = x1 - 1; j < x2; j++) {
                int rowSum = round[j][y2 - 1];

                if (y1 > 1) {
                    rowSum -= round[j][y1 - 2];
                }
                total += rowSum;
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
