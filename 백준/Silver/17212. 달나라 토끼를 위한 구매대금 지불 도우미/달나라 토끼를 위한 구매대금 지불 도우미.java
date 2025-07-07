import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] coins = {1, 2, 5, 7};
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp(i);
        }

        System.out.println(dp[N]);
    }

    private static int dp(int number) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > number) {
                break;
            }
            min = Math.min(min, dp[number - coin] + 1);
        }
        return min;
    }
}
