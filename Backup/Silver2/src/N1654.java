import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer KN = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(KN.nextToken());
        int N = Integer.parseInt(KN.nextToken());

        int[] arr = new int[K];

        long max = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }

        max++;

        long minnumber = 0;
        long mid;

        while (minnumber < max) {

            mid = (max + minnumber) / 2;

            long count = 0;

            for (int j : arr) {
                count += (j / mid);
            }

            if(count < N) {
                max = mid;
            }
            else {
                minnumber = mid + 1;
            }

        }
        System.out.println(minnumber - 1);
    }
}