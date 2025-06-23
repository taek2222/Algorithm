import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int count = 0;
        for (int i = 0; i < M - 1; i++) {

            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;

                if (count == N) {
                    int index = i - (2 * count - 1);
                    if (index >= 0 && S.charAt(index) == 'I') {
                        answer++;
                    }
                    count--;
                }
                i += 1;
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
