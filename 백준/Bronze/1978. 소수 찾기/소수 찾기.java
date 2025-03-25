import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 4 1 3 5 7
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> inputNumbers = List.of(br.readLine().split(" "));
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber));
        }

        int answer = 0;
        for (Integer number : numbers) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                answer++;
            }
        }

        bw.append(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
