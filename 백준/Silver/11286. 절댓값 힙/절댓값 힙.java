import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            int firstNumberAbs = Math.abs(n1);
            int secondNumberAbs = Math.abs(n2);

            if (firstNumberAbs == secondNumberAbs) {
                return Integer.compare(n1, n2);
            }

            return Integer.compare(firstNumberAbs, secondNumberAbs);
        });

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.equals("0")) {
                int number;

                if (queue.isEmpty()) {
                    number = 0;
                } else {
                    number = queue.poll();
                }

                sb.append(number).append("\n");
                continue;
            }

            queue.add(Integer.parseInt(command));
        }

        System.out.println(sb);
    }
}
