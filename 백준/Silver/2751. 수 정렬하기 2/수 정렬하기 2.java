import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(inputs);
        for (int element : inputs) {
            sb.append(element).append("\n");
        }

        System.out.println(sb);
    }
}
