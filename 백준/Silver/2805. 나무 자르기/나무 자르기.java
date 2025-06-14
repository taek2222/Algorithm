import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];

        int maxValue = Integer.MIN_VALUE;
        int minValue = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            if (tree > maxValue) {
                maxValue = tree;
            }
        }

        int answer = 0;
        while (minValue <= maxValue) {
            int threshold = (maxValue + minValue) / 2;
            long totalLength = 0;

            for (int i = 0; i < N; i++) {
                int treeLength = trees[i];

                if (totalLength >= M) {
                    break;
                }

                if (treeLength > threshold) {
                    int length = treeLength - threshold;
                    totalLength += length;
                }
            }

            if (totalLength >= M) {
                answer = threshold;
                minValue = threshold + 1;
            } else {
                maxValue = threshold - 1;
            }
        }

        System.out.println(answer);
    }
}
