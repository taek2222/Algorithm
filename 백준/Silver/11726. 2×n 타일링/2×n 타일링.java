import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] tiling = new long[n + 1];
        tiling[0] = 1;
        tiling[1] = 2;

        for (int i = 2; i < n; i++) {
            tiling[i] = tiling[i - 2] + tiling[i - 1];
            tiling[i] = tiling[i] % 10_007;
        }

        System.out.println(tiling[n - 1]);
    }
}
