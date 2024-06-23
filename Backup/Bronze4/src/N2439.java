import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for(int i = 0; i < number; i++) {
            for (int j = number - 1; j > i; j--)
                System.out.print(" ");
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}