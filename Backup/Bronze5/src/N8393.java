import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0;i <= max; i++)
            total += i;
        System.out.println(total);
    }
}
