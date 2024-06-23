import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        boolean[][] array = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                array[i][j] = str[j].equals("W");
            }
        }

        int gab;
        int min = 2500;

        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                gab = Math.abs(CN(array, i, j));
                if(gab < min)
                    min = gab;
            }
        }
        System.out.println(min);
    }

    public static int CN(boolean[][] array, int N, int M) {
        int count_1 = 0;
        int count_2 = 0;
        boolean center = array[N][M];
        for(int i = N; i < N+8; i++) {
            for(int j = M; j < M+8; j++) {
                if(center != array[i][j]) count_1++;
                else count_2++;
                center = !center;
            }
            center = !center;
        }
        return Math.min(count_1, count_2);
        
    }
}
