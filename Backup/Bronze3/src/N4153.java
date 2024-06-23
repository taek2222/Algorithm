import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer ABC = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(ABC.nextToken());
        int B = Integer.parseInt(ABC.nextToken());
        int C = Integer.parseInt(ABC.nextToken());
        while(!(A == 0 && B == 0 && C == 0)) {

            if(Math.pow(A, 2) + Math.pow(B, 2) == Math.pow(C, 2))
                System.out.println("right");
            else if(Math.pow(A, 2) + Math.pow(C, 2) == Math.pow(B, 2))
                System.out.println("right");
                else if(Math.pow(B, 2) + Math.pow(C, 2) == Math.pow(A, 2))
                System.out.println("right");
                else
                System.out.println("wrong");

            ABC = new StringTokenizer(br.readLine());
            A = Integer.parseInt(ABC.nextToken());
            B = Integer.parseInt(ABC.nextToken());
            C = Integer.parseInt(ABC.nextToken());
        }
    }
}