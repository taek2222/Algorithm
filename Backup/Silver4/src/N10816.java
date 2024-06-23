import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N 값 읽기
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) // 상근이 숫자 카드 값 정렬 및 삽입
            card[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine()); // M 값 읽기
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(card, key) - lowerBound(card, key)).append(' ');
        }
        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
