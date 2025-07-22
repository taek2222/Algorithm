import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long startPos = 0;
        long endPos = n;

        if (n == 0) {
            System.out.println("0");
            return;
        }

        if (n == 1) {
            System.out.println("1");
            return;
        }

        long answer = endPos;
        while (startPos <= endPos) {
            long mid = (startPos + endPos) / 2;
            if (mid <= n / mid) {
                answer = mid;
                startPos = mid + 1;
            } else {
                endPos = mid - 1;
            }
        }

        System.out.println(answer * answer == n ? answer : answer + 1);
    }
}
