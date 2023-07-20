import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Number = Integer.parseInt(br.readLine());
        int Total = 0;

        Total += Number / 5;
        Total += Number / 25;
        Total += Number / 125;

        System.out.println(Total);
    }
}
