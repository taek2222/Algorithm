import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arraystr = str.split("");
        int total = 0;
        for(int i = 0; i < num; i++)
            total += Integer.parseInt(arraystr[i]);
        System.out.println(total);
    }
}
