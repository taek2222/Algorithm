import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(br.readLine());

        for(; 0 < max; max--)
            System.out.println(max);
    }
}