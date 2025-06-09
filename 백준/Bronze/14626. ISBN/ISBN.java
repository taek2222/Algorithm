import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split("");
        int multiply = 1;
        int total = 0;
        for (int i = 0; i < 13; i++) {
            String number = numbers[i];

            if (number.equals("*")) {
                multiply = i;
            } else {
                int drainage = i % 2 == 0 ? 1 : 3;
                total += Integer.parseInt(number) * drainage;
            }
        }

        int answer = 1;
        multiply = multiply % 2 == 0 ? 1 : 3;
        while (true) {
            if ((answer * multiply + total) % 10 == 0) {
                break;
            }

            answer++;
        }

        System.out.println(answer % 10);
    }
}
