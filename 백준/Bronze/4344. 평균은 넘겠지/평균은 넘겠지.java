import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 5
 * 5 50 50 70 80 100
 * 7 100 95 90 80 70 60 50
 * 3 70 90 80
 * 3 70 90 81
 * 9 100 99 98 97 96 95 94 93 91
 *
 * 40.000%
 * 57.143%
 * 33.333%
 * 66.667%
 * 55.556%
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            List<Integer> numbers = new ArrayList<>();
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            double average = average(numbers);

            int count = 0;
            for (Integer number : numbers) {
                if (number > average) {
                    count++;
                }
            }
            double percent = (count * 1000.0) / numbers.size();
            double result = Math.round(percent * 100) / 1000.0;

            bw.append(String.valueOf(result)).append("%\n");
        }

        br.close();
        bw.close();
    }

    private static double average(List<Integer> numbers) {
        int sum = numbers.stream()
                .mapToInt(index -> index)
                .sum();
        return (double) sum / numbers.size();
    }
}
