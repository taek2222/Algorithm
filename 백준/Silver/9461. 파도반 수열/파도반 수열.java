import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] square = new long[101];
        for (int i = 0; i < square.length; i++) {
            if (i <= 2) {
                square[i] = 1;
                continue;
            }
            if (i <= 4) {
                square[i] = 2;
                continue;
            }
            square[i] = square[i - 1] + square[i - 5];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(square[N - 1])).append("\n");
        }

        bw.flush();
    }
}
