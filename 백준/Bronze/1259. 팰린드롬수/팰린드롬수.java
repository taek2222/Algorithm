import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 121
 * 1231
 * 12421
 * 0
 * <p>
 * yes
 * no
 * yes
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            String reversInput = "";
            for (int i = 1; i <= input.length(); i++) {
                reversInput += input.charAt(input.length() - i);
            }

            if (input.equals(reversInput)) {
                bw.append("yes").append("\n");
                continue;
            }
            bw.append("no").append("\n");
        }

        br.close();
        bw.close();
    }
}
