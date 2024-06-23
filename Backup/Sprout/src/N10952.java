import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str.nextToken());
            int n2 = Integer.parseInt(str.nextToken());
            if(n1 == 0 && n2 == 0)
                break;
            System.out.println(n1 + n2);
        }
    }
}
