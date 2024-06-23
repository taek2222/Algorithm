import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int[][] number = new int[15][14];

        for(int i = 0; i < number[0].length; i++)
            number[0][i] = i+1;

        for(int i = 1; i < number.length; i++) {
            number[i][0] = 1;
            for(int j = 1; j < number[i].length; j++)
                number[i][j] = number[i][j-1] + number[i-1][j];
        }

        for(int i = 0; i < num; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(number[k][n - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
