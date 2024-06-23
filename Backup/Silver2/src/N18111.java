import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        int max = 0, min = 257;

        for (int i = 0; i < N; i++) { // 입력 값 배열로 저장
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] > max)
                    max = array[i][j];
                if(array[i][j] < min)
                    min = array[i][j];
            }
        }

        int result_Time = 99999999, result_Floor = 0;
        for(int i = min; i <= max; i++) {
            int Time = 0;
            int Block = B;

            for(int j = 0; j < N; j++)
                for(int k = 0; k < M; k++) {
                    if(array[j][k] > i) {
                        Time += (array[j][k] - i) * 2;
                        Block += array[j][k] - i;
                    }
                    else {
                        Time += (i - array[j][k]);
                        Block -= (i - array[j][k]);
                    }
                }

            if (Block < 0)
                break;

            if (Time <= result_Time) {
                result_Time = Time;
                result_Floor = i;
            }

        }

        System.out.println(result_Time + " " + result_Floor);
    }
}
