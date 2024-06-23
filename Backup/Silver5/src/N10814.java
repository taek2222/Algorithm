import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] memberage = new int[Integer.parseInt(br.readLine())][2];
        String[] membername = new String[memberage.length];
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < memberage.length; i++) {
            StringTokenizer agename = new StringTokenizer(br.readLine());
            memberage[i][0] = Integer.parseInt(agename.nextToken());
            memberage[i][1] = i;
            membername[i] = agename.nextToken();
        }

        Arrays.sort(memberage, (o1, o2) -> o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);

        for (int[] ints : memberage) str.append(ints[0]).append(" ").append(membername[ints[1]]).append("\n");

        System.out.print(str);
    }
}
