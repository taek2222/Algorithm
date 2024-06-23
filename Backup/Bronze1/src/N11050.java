import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        if(K < 0 || K > N)
            System.out.print(0);
        else
            System.out.println(factorial(N)/(factorial(K)*factorial(N-K)));
    }

    public static int factorial(int number) {
        int total = 1;
        for(int i = 2; i <= number; i++)
            total *= i;
        return total;
    }
}
