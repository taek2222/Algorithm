import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        if((A / C) >= (B / D)) {
            if (A % C == 0)
                System.out.print(L - (A / C));
            else System.out.print(L - ((A / C) + 1));
        }
        else {
            if (B % D == 0)
                System.out.print(L - (B / D));
            else System.out.print(L - ((B / D) + 1));
        }
    }
}
