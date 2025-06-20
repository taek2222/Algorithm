import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(long A, long value, long C) {
        if (value == 1) {
            return A % C;
        }

        long result = pow(A, value / 2, C);

        if (value % 2 == 1) {
            return (result * result % C) * A % C;
        }

        return result * result % C;
    }
}
