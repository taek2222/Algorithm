import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long total = 0L;
        while (st.hasMoreTokens()) {
            total += Long.parseLong(st.nextToken());
        }

        System.out.println(total);
    }
}
