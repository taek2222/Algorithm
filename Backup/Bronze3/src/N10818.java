import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(str.nextToken());
        int max = number, min = number;

        for(int i = 1; i < num; i++)
        {
            number = Integer.parseInt(str.nextToken());
            if(number > max)
                max = number;
            if(number < min)
                min = number;
        }
        System.out.print(min + " " + max);
    }
}
