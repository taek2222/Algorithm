import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static String S;
    static String P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int oCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; oCount < N; i++) {
            if (i % 2 == 0) {
                sb.append("I");
            } else {
                sb.append("O");
                oCount++;
            }
        }
        P = sb.append("I").toString();

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (P.charAt(0) == S.charAt(i)) {
                if (search(i + 1)) {
                    answer++;
                    i += 1;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean search(int fromIndex) {
        for (int i = 1; i < P.length(); i++, fromIndex++) {
            if (fromIndex >= S.length() || P.charAt(i) != S.charAt(fromIndex)) {
                return false;
            }
        }
        return true;
    }
}
