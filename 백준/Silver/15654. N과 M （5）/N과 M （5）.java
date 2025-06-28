import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] numbers;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        loop(0, M, new boolean[10_001], new String[M]);
        bw.flush();
    }

    private static void loop(int depth, int M, boolean[] visit, String[] result) throws IOException {
        if (depth == M) {
            bw.append(String.join(" ", result)).append("\n");
            return;
        }

        for (final int number : numbers) {
            if (visit[number]) {
                continue;
            }
            result[depth] = String.valueOf(number);
            visit[number] = true;
            loop(depth + 1, M, visit, result);
            visit[number] = false;
        }
    }
}
