import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> inputs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        List<String> sorted = inputs.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .collect(Collectors.toList());

        for (String element : sorted) {
            System.out.println(element);
        }
    }
}
