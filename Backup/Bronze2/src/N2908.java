import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer number = new StringTokenizer(br.readLine());

        int restive = 0;
        int[] numberarray = new int[4];

        for(int i = 0; i < 2; i++) {
            int num = Integer.parseInt(number.nextToken());
            for(int j = 0; j < 3; j++) {
                int team = num % 10;
                restive = restive * 10 + team;
                num /= 10;
            }
            numberarray[i] = restive;
            restive = 0;
        }
        System.out.println(Math.max(numberarray[0], numberarray[1]));

    }
}
