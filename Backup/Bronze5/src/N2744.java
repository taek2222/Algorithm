import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strarry = str.split("");

        for (String s : strarry) {
            if (s.compareTo("_") > 0)
                System.out.print(s.toUpperCase());
            else
                System.out.print(s.toLowerCase());
        }

    }
}
