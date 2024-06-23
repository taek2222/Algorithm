import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer number = new StringTokenizer(br.readLine());

        BigInteger n1 = new BigInteger(number.nextToken());
        BigInteger n2 = new BigInteger(number.nextToken());
        System.out.print(n1.multiply(n2));
    }
}
