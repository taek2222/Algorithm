import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer number = new StringTokenizer(br.readLine()); // ex) 1000 100

        BigInteger n1 = new BigInteger(number.nextToken()); // 1000
        BigInteger n2 = new BigInteger(number.nextToken()); // 100
        System.out.println(n1.divide(n2)); // 10
        System.out.println(n1.remainder(n2)); // 0
    }
}