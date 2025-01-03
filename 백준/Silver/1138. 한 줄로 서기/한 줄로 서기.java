import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputNumber = br.readLine().split(" ");

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(inputNumber[i]);
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (answer[j] == 0) {
                    if (number == count) {
                        answer[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        String[] array = Arrays.stream(answer)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        System.out.println(String.join(" ", array));
    }
}