import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            aList.add(a);
        }

        int count = 0;
        for (int i = aList.size() - 1; i >= 0; i--) {
            Integer num = aList.get(i);
            if (num > K) {
                continue;
            }
            int quotient = K / num;
            count += quotient;
            K -= num * quotient;
        }

        System.out.println(count);
    }
}
