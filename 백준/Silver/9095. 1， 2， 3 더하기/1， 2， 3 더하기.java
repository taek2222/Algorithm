import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = new int[12];
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        for (int i = 4; i < 12; i++) {
            answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(answer[n])).append("\n");
        }

        bw.flush();
    }
}
