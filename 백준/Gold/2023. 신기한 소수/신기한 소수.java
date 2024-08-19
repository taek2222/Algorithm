import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        final int maxNum = (int) Math.pow(10, N);
        final int minNum = maxNum / 10;

        for(int i = minNum; i < maxNum; i++)
            for (int j = 0; j < N; j++) {
                int num = (j == 0 ? (i / minNum) : i / (minNum / (int) Math.pow(10, j)));
                if (!isPrime(num))
                    break;

                if (j == N-1)
                    sb.append(i).append("\n");
            }

        System.out.println(sb);
    }

    static public boolean isPrime(int n) {
        if (n == 1)
            return false;
        
        for (int i = 2; i <= (int)Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
