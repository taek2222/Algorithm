import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] number;

        StringTokenizer AB = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(AB.nextToken());
        int B = Integer.parseInt(AB.nextToken());

        number = new int[A];

        StringTokenizer numberstr = new StringTokenizer(br.readLine());

        for(int i = 0; i < number.length; i++)
            number[i] = Integer.parseInt(numberstr.nextToken());

        for (int j : number)
            if (j < B)
                System.out.print(j + " ");
    }
}
