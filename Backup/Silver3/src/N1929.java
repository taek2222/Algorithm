import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1929 {
    public static boolean[] bl;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        bl = new boolean[N+1];

        prime();

        for(int i = M; i <= N; i++)
            if(!bl[i]) System.out.println(i);
    }
    public static void prime() {
        bl[0] = bl[1] = true;

        for(int i = 2; i <= Math.sqrt(bl.length); i++) {
            if (bl[i]) continue;
            for(int j = i*i; j < bl.length; j += i)
                bl[j] = true;
        }
    }
}