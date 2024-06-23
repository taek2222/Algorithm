import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(str.nextToken());
                int n2 = Integer.parseInt(str.nextToken());
                System.out.println(n1 + n2);
            }catch (Exception e1){
                break;
            }
        }
    }
}
