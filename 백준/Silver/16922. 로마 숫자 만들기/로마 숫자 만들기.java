import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Main {
    static int[] numbers = {1, 5, 10, 50};
    static int n;
    static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);
        System.out.println(answer.size());
    }

    private static void dfs(int depth, int sum, int index) {

        for (int i = index; i < numbers.length; i++) {
            sum += numbers[i];

            if (n - 1 == depth) {
                answer.add(sum);
                sum -= numbers[i];
                continue;
            }

            dfs(depth + 1, sum, i);
            sum -= numbers[i];
        }
    }
}