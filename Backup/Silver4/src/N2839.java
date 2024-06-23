import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        for (int i = number / 5; i > 0; i--) {
            if((number-(i * 5)) % 3 == 0) {
                System.out.print(i + (number - (i * 5)) / 3);
                System.exit(0);
            }
        }
        if(number % 3 == 0)
            System.out.print(number/3);
        else
            System.out.print(-1);
    }
}
