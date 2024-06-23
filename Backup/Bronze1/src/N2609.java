import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer number = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(number.nextToken());
        int n2 = Integer.parseInt(number.nextToken());
        int measure = get(n1, n2);
        System.out.println(measure);
        System.out.println((n1 * n2) / measure);
    }

    public static int get(int n1, int n2) {
        if(n1 % n2 == 0)
            return n2;
        return get(n2, n1%n2);
    }
}
