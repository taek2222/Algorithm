import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Main {

    static Map<Integer, int[]> answers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answers.put(0, new int[]{1, 0});
        answers.put(1, new int[]{0, 1});

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] answer = fibonacci(N);

            bw.append(String.valueOf(answer[0])).append(" ").append(String.valueOf(answer[1])).append("\n");
        }

        bw.flush();
    }

    private static int[] fibonacci(final int n) {
        if (answers.containsKey(n)) {
            return answers.get(n);
        }

        if (answers.containsKey(n-2) && answers.containsKey(n-1)) {
            int[] value1 = answers.get(n - 2);
            int[] value2 = answers.get(n - 1);

            int[] result = {(value1[0] + value2[0]), value1[1] + value2[1]};
            answers.put(n, result);
            return answers.get(n);
        }

        int[] fibonacci = fibonacci(n - 2);
        int[] fibonacci1 = fibonacci(n - 1);
        int[] result = {(fibonacci[0] + fibonacci1[0]), fibonacci[1] + fibonacci1[1]};

        answers.put(n, result);
        return answers.get(n);
    }
}
