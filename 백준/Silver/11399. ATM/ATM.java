import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static String line;
    static int i;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);

        int total = 0;
        int result = 0;
        for (Integer number : numbers) {
            total = total + number;
            result += total;
        }

        System.out.println(result);
    }
}
