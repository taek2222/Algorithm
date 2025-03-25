import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 24 18
 * <p>
 * 6 72
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        int min = Integer.min(num1, num2);

        for (int i = min; i >= 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                bw.append(String.valueOf(i)).append("\n");
                break;
            }
        }

        int i = 0;
        int j = 1;
        int copyNum2;
        while (true) {
            i++;
            int copyNum1 = num1 * i;
            while (true) {
                copyNum2 = num2 * j;
                if (copyNum1 <= copyNum2) {
                    break;
                }
                j++;
            }
            if (copyNum1 == copyNum2) {
                bw.append(String.valueOf(copyNum1));
                break;
            }
        }

        br.close();
        bw.close();
    }
}
