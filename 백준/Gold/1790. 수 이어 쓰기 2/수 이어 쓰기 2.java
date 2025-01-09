import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            int length = (int) Math.log10(i) + 1;
            if (length >= k) {
                String number = String.valueOf(i);
                System.out.println(number.charAt(k - 1));
                System.exit(0);
            }
            k -= length;
        }

        System.out.println("-1");
    }
}