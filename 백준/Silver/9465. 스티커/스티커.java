import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 2][2];
            int[][] number = new int[n][2];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    number[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 2; j < dp.length; j++) {
                for (int k = 0; k < dp[0].length; k++) {
                    dp[j][k] = max(j, k) + number[j - 2][k];
                }
            }

            bw.append(String.valueOf(Math.max(dp[n + 1][0], dp[n + 1][1]))).append("\n");
        }

        bw.flush();
    }

    private static int max(int startX, int startY) {
        int max = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = startX - 2; j < startX; j++) {
                if (i == startY && j == startX - 1) {
                    continue;
                }
                max = Math.max(max, dp[j][i]);
            }
        }
        return max;
    }
}
