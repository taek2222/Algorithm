import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(str.nextToken()), b;
        int Up = 0, Down = 0;

        for(int i = 0; i < 7; i++) {
            b = Integer.parseInt(str.nextToken());
            if(a < b)
                Up++;
            else
                Down++;
            a = b;
        }


        if(Up == 7)
            System.out.println("ascending");
        else if(Down == 7)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
