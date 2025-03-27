import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * UFRN
 * <p>
 * It is a prime word. It is not a prime word.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] inputs = br.readLine().toCharArray();
        int number = 0;

        for (char input : inputs) {
            if (Character.isUpperCase(input)) {
                number += (input - 38);
                continue;
            }
            number += (input - 96);
        }

        if (isDecimal(number)) {
            bw.append("It is a prime word.");
        } else {
            bw.append("It is not a prime word.");
        }

        br.close();
        bw.close();
    }

    private static boolean isDecimal(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
            if (count >= 3) {
                return false;
            }
        }
        return true;
    }
}
