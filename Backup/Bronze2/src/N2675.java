import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer str;
        int loop;
        String[] en;

        for(int i = 0; i < num; i++)
        {
            str = new StringTokenizer(br.readLine());
            loop = Integer.parseInt(str.nextToken());
            en = str.nextToken().split("");
            for (String s : en)
                for (int k = 0; k < loop; k++)
                    System.out.print(s);
            System.out.println();

        }
    }
}