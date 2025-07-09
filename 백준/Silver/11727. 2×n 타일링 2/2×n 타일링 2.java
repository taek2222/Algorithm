import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answers = new int[n + 2];
        answers[1] = 1;
        answers[2] = 3;

        for (int i = 3; i < answers.length; i++) {
            answers[i] = (answers[i - 1] + (answers[i - 2] * 2)) % 10_007;
        }

        System.out.println(answers[n]);
    }
}
