import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numberarray = new int[Integer.parseInt(br.readLine())];
        StringTokenizer str = new StringTokenizer(br.readLine());
        int decimal = 0;

        for (int i = 0; i < numberarray.length; i++)
            numberarray[i] = Integer.parseInt(str.nextToken());

        for (int i = 0; i < numberarray.length; i++){
            int num = numberarray[i];
            int check = 0;
            for(int j = 2; j <= num; j++) {
                if (num % j == 0)
                    check++;
                if (check > 1)
                    break;
            }
            if(check == 1)
                decimal++;
        }
        System.out.print(decimal);
    }
}