import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num1 = new int[Integer.parseInt(br.readLine())];
        StringBuilder str = new StringBuilder();

        StringTokenizer number = new StringTokenizer(br.readLine());
        for(int i = 0; i < num1.length; i++)
            num1[i] = Integer.parseInt(number.nextToken());

        int size = Integer.parseInt(br.readLine());
        StringTokenizer number2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++) {
            int get = Integer.parseInt(number2.nextToken());
            int check = 0;
            for (int k : num1)
                if (get == k) {
                    check++;
                    break;
                }
            if(check > 0)
                str.append("1\n");
            else
                str.append("0\n");
        }
        System.out.print(str);
    }
}