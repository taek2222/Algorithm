import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer numMax = new StringTokenizer(br.readLine());
        int[] number = new int[Integer.parseInt(numMax.nextToken())];
        int Max = Integer.parseInt(numMax.nextToken());
        int Min = 0;

        StringTokenizer numberstr = new StringTokenizer(br.readLine());

        for(int i = 0; i < number.length; i++)
            number[i] = Integer.parseInt(numberstr.nextToken());

        for(int i = 0; i < number.length - 2; i++) {
            int total = number[i];

            for(int j = i + 1; j < number.length - 1; j++) {
                int total2 = total + number[j];

                for(int k = j + 1; k < number.length; k++) {
                    int total3 = total2 + number[k];
                    if(total3 <= Max)
                        if(Max - Min >= Max - total3) {
                            Min = total3;
                        }
                }
            }
        }
        System.out.println(Min);
    }
}
