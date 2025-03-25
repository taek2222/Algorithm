import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 6 8 10 25 52 60 5 12 13 0 0 0
 * <p>
 * <p>
 * right wrong right
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> inputNumbers = List.of(br.readLine().split(" "));
        while (!inputNumbers.get(0).equals("0")) {
            List<Integer> numbers = new ArrayList<>();
            for (String inputNumber : inputNumbers) {
                numbers.add(Integer.parseInt(inputNumber));
            }

            Collections.sort(numbers);
            double sqrt = Math.sqrt(Math.pow(numbers.get(0), 2) + Math.pow(numbers.get(1), 2));
            if (sqrt == numbers.get(2)) {
                bw.append("right").append("\n");
            } else {
                bw.append("wrong").append("\n");
            }
            inputNumbers = List.of(br.readLine().split(" "));
        }

        br.close();
        bw.close();
    }
}
