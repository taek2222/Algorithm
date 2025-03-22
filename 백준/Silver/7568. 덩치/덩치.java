import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int[][] size = new int[Integer.parseInt(br.readLine())][2];
        for (int i = 0; i < size.length; i++) {
            StringTokenizer WH = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(WH.nextToken());
            size[i][1] = Integer.parseInt(WH.nextToken());
        }
        for(int i = 0; i < size.length; i++) {
            int weight = size[i][0];
            int height = size[i][1];
            int k = 0;
            for(int j = 0; j < size.length; j++) {
                if(weight < size[j][0] && height < size[j][1])
                    k++;
            }
            str.append(k+1).append(" ");
        }
        System.out.print(str);
    }
}