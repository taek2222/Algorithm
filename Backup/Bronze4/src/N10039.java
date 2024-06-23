import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;

        for(int i = 0; i < 5; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number < 40)
                number = 40;
            total += number;
        }
        System.out.println(total / 5);
    }
}
