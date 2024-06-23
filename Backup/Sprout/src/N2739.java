import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 9; i++)
            System.out.println(number + " * " + i + " = " + number*i);
    }
}