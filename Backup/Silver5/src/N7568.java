import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int[][] size = new int[Integer.parseInt(br.readLine())][2];
        for (int i = 0; i < size.length; i++) {
            StringTokenizer WH = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(WH.nextToken());
            size[i][1] = Integer.parseInt(WH.nextToken());
        }
        for (int[] ints : size) {
            int weight = ints[0];
            int height = ints[1];
            int k = 0;
            for (int[] value : size) {
                if (weight < value[0] && height < value[1])
                    k++;
            }
            str.append(k + 1).append(" ");
        }
        System.out.print(str);
    }
}
