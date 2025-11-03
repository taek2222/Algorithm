import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String functions = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] array = line.substring(1, line.length() - 1).split(",");

            boolean reverseFlag = false;
            int startPos = 0;
            int endPos = n;
            for (int pos = 0; pos < functions.length(); pos++) {
                char function = functions.charAt(pos);

                if (function == 'R') {
                    reverseFlag = !reverseFlag;
                    continue;
                }

                if (reverseFlag) {
                    endPos--;
                } else {
                    startPos++;
                }
            }

            if (startPos > endPos) {
                sb.append("error").append("\n");
                continue;
            }

            String[] numbers = new String[endPos - startPos];
            int index = 0;

            if (!reverseFlag) {
                for (int j = startPos; j < endPos; j++) {
                    numbers[index] = array[j];
                    index++;
                }
            } else {
                for (int j = endPos - 1; j >= startPos; j--) {
                    numbers[index] = array[j];
                    index++;
                }
            }

            sb.append("[").append(String.join(",", numbers)).append("]").append("\n");
        }

        System.out.println(sb);
    }
}
