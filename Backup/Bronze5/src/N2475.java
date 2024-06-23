import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = str.countTokens();
        int total = 0;

        for(int i = 0; i < count; i++) {
            int number = Integer.parseInt(str.nextToken());
            total += Math.pow(number, 2);
        }
        System.out.println(total%10);
    }
}
