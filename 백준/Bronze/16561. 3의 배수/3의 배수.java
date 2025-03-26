import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 5 5 50 50 70 80 100 7 100 95 90 80 70 60 50 3 70 90 80 3 70 90 81 9 100 99 98 97 96 95 94 93 91
 * <p>
 * 40.000% 57.143% 33.333% 66.667% 55.556%
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cut = n / 3;
        int maxRange = (cut - 2) * 3;

        int answer = 0;
        for (int i = 3; i <= maxRange; i += 3) {
            if (n - i < 0) break;
            for (int j = 3; j <= maxRange; j += 3) {
                if (n - i - j < 0) break;
                for (int k = 3; k <= maxRange; k += 3) {
                    if (n - i - j - k < 0) break;
                    if (n - i - j - k == 0) {
                        answer++;
                    }
                }
            }
        }

        bw.append(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
