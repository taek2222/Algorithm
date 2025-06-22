import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        int[] dpCopy = new int[n + 2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 1;
            while (st.hasMoreElements()) {
                int maxed = Math.max(dp[index], dp[index - 1]);
                dpCopy[index] = maxed + Integer.parseInt(st.nextToken());
                index++;
            }
            dp = dpCopy.clone();
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }
}
