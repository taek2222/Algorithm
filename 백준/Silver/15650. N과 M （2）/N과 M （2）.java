import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N, M, 1, new String[M], 0);
        bw.flush();
    }

    private static void recursive(int N, int M, int fromNumber, String[] array, int index) throws IOException {
        for (int i = fromNumber; i <= N; i++) {
            array[index] = String.valueOf(i);

            if (M == index + 1) {
                bw.append(String.join(" ", array)).append("\n");
            } else {
                recursive(N, M, i + 1, array, index + 1);
            }
        }
    }
}
