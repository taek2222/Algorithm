import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int number = 0;
                for (int k = j; k < dp[0].length; k++) {
                    number += dp[i - 1][k];
                }
                dp[i][j] = number % 10_007;
            }
        }

        System.out.println(dp[N][0]);
    }
}
