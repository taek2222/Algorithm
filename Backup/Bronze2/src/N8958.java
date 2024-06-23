import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int total = 0, win = 0;

        for(int i = 0; i < loop; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String[] strarry = str.nextToken().split("");

            for (String OX : strarry) {
                if(OX.equals("O")) {
                    win++;
                    total += win;
                }
                else if(OX.equals("X"))
                    win = 0;
            }
            System.out.println(total);
            total = 0; win = 0;
        }
    }

}
