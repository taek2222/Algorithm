import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] number = new int[Integer.parseInt(br.readLine())][2];
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < number.length; i++) {
            StringTokenizer num = new StringTokenizer(br.readLine());
            number[i][1] = Integer.parseInt(num.nextToken());
            number[i][0] = Integer.parseInt(num.nextToken());
        }
        Arrays.sort(number, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for (int[] ints : number) {
            str.append(ints[1]).append(" ");
            str.append(ints[0]).append("\n");
        }
        System.out.print(str);
    }
}
