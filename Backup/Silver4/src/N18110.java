import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 문제 난이도 의견 갯수

        if (n==0) { // 의견의 갯수가 0일 경우 종료
            System.out.println(0);
            System.exit(0);
        }

        int[] number = new int[n];

        for(int i = 0; i < n; i++) // 의견을 int 배열에 삽입
            number[i] = Integer.parseInt(br.readLine());
        Arrays.sort(number); // 의견 배열 정렬

        double gap = n * 0.15;
        int sol = (int)Math.round(gap);
        int total = 0;

        for(int i = sol; i < n - sol; i++)
            total += number[i];

        double end = (double)total / (n - sol * 2);
        int result = (int)Math.round(end);

        System.out.println(result);
    }
}
