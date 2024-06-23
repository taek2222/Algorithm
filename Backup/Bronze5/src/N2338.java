import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class N2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n1 = new BigInteger(br.readLine());
        BigInteger n2 = new BigInteger(br.readLine());

        System.out.println(n1.add(n2));
        System.out.println(n1.subtract(n2));
        System.out.println(n1.multiply(n2));
    }
}
