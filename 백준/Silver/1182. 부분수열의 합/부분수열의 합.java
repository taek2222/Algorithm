import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int S;
    static int[] numbers;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        String[] strNumbers = br.readLine().split(" ");
        for (int i = 0; i < strNumbers.length; i++)
            numbers[i] = Integer.parseInt(strNumbers[i]);

        DFS(0, 0, false);
        System.out.println(answer);
    }

    private static void DFS(int depth, int sum, boolean select) {
        if (depth == N) {
            if (sum == S && select)
                answer++;
            return;
        }

        DFS(depth + 1, sum + numbers[depth], true);

        DFS(depth + 1, sum, select);
    }
}