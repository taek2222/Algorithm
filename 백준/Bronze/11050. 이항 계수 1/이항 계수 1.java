import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 5 2
 * <p>
 * <p>
 * 10
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        int result = factorial(num1) / (factorial(num2) * factorial(num1 - num2));

        bw.append(String.valueOf(result));

        br.close();
        bw.close();
    }

    private static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        int sum = number;
        for (int i = number - 1; i >= 1; i--) {
            sum *= i;
        }
        return sum;
    }
}
