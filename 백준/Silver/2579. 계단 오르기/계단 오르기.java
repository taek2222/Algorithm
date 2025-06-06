import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairsCount = Integer.parseInt(br.readLine());

        stairs = new int[stairsCount + 1];
        dp = new int[stairsCount + 1];

        for (int i = 1; i <= stairsCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (stairsCount > 1) {
            dp[2] = stairs[1] + stairs[2];
        }
        if (stairsCount > 2) {
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        }

        for (int i = 4; i <= stairsCount; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        System.out.println(dp[stairsCount]);
    }
}
