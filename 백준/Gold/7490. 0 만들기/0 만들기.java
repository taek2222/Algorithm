import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int n;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");

            System.out.println(sb);
        }
    }

    private static void dfs(int idx, int num, int sum, int operator, String print) {
        if (idx == n) {
            sum += (num * operator);
            if (sum == 0) {
                sb.append(print).append("\n");
            }
            return;
        }

        dfs(idx + 1, num * 10 + (idx + 1), sum, operator, print + " " + (idx + 1));
        dfs(idx + 1, idx + 1, sum + (num * operator), 1, print + "+" + (idx + 1));
        dfs(idx + 1, idx + 1, sum + (num * operator), -1, print + "-" + (idx + 1));
    }
}