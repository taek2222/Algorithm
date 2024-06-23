import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int bignumber = 0, bigposition = 0;
            for(int i = 0; i < 9; i++) {
                int number = Integer.parseInt(br.readLine());
                if(number > bignumber) {
                    bignumber = number;
                    bigposition = i+1;
                }
            }
            System.out.println(bignumber);
            System.out.println(bigposition);
    }
}