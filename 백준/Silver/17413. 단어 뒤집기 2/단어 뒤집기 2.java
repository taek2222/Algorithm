import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder common;
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split("");

        for (int i = 0; i < s.length; ) {
            if (s[i].equals("<")) {
                common = new StringBuilder();

                while (!s[i].equals(">"))
                    common.append(s[i++]);

                common.append(s[i++]);
                sb.append(common);
            }
            else if(!s[i].equals(" ")){
                common = new StringBuilder();
                while (!(i == s.length) && !s[i].equals("<") && !s[i].equals(" "))
                    common.append(s[i++]);

                common.reverse();

                sb.append(common);
            }
            else
                sb.append(s[i++]);
        }
        System.out.println(sb);
    }
}
