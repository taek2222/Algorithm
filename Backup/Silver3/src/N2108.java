import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        int Total = 0;

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
            Total += number[i];
        }
        Arrays.sort(number);

        boolean flag = false;
        int mode = 0;
        int max_count = 0;

        for(int i = 0; i < N; ) {
            int count = 0; // number[i] 에 해당하는 동일한 숫자 계산 변수
            int skip = 0;
            int num = number[i];

            for(int j = i; j < N; j++) {
                if(num != number[j])
                    break;
                count++;
                skip++;
            }

            if(count > max_count) {
                max_count = count;
                mode = num;
                flag = true;
            }
            else if(count == max_count && flag) {
                mode = num;
                flag = false;
            }
            i += skip;
        }

        System.out.println((int)Math.round((double)Total / N)); // 산술 평균
        System.out.println(number[(N/2)]); // 중앙값
        System.out.println(mode);
        System.out.println(number[N-1] - number[0]); // 범위 출력

    }
}