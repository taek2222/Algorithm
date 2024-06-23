import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder print = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            int dis = 0;
            int check = 0;

            for (String s : str) {
                if (s.equals("(")) dis++;
                if (s.equals(")")) dis--;

                if (dis < 0) {
                    print.append("NO\n");
                    check = 1;
                    break;
                }

            }

            if(check == 0 && dis == 0)
                print.append("YES\n");
            if(check == 0 && !(dis == 0))
                print.append("NO\n");
        }

        System.out.print(print);
    }
}
