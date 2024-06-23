import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ABV = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(ABV.nextToken());
        int B = Integer.parseInt(ABV.nextToken());
        int V = Integer.parseInt(ABV.nextToken());

        int day = (V - A) / (A - B) + 1;
        if((V - A) % (A - B) != 0)
            day++;
        System.out.println(day);
    }
}
