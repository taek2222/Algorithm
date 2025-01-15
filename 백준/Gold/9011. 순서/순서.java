import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> answer = new ArrayList<>();
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                numbers.add(j);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> reverseRs = new ArrayList<>();
            while (st.hasMoreTokens()) {
                reverseRs.add(Integer.parseInt(st.nextToken()));
            }
            Collections.reverse(reverseRs);

            boolean possible = true;
            for (int r : reverseRs) {
                if (r >= numbers.size()) {
                    sb.append("IMPOSSIBLE").append("\n");
                    possible = false;
                    break;
                }

                int number = numbers.get(r);
                answer.add(number);
                numbers.remove(r);
            }

            if (possible) {
                Collections.reverse(answer);
                for (int number : answer) {
                    sb.append(number).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}