import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(token.nextToken());
            int F = Integer.parseInt(token.nextToken());
            if(M == 0)
                break;
            System.out.println(M+F);
        }

    }
}
