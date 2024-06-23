import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine()) - 1;
        if(number == 0) {
            System.out.println(1);
            System.exit(0);
        }
        for(int i = 1; ;i++) {
            number -= 6 * i;
            if (number <= 0) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
    }
}
