import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] remainArray = new int[1024];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 분자
            int D = Integer.parseInt(st.nextToken()); // 분모

            int remain = M;
            int idx = 1;
            int start, end;

            while (true) {
                remain %= D;

                if (remainArray[remain] != 0) {
                    start = remainArray[remain];
                    end = idx;
                    break;
                }
                remainArray[remain] = idx++;
                remain *= 10;
            }

            sb.append(M/D).append(".");
            M = M % D * 10;
            M = buildDivisionQuotient(1, start, sb, M, D);

            sb.append("(");
            buildDivisionQuotient(start, end, sb, M, D);
            sb.append(")").append("\n");
        }
        System.out.println(sb);
    }

    private static int buildDivisionQuotient(int min, int max, StringBuilder sb, int M, int D) {
        for (int index = min; index < max; index++) {
            sb.append(M / D);
            M = M % D * 10;
        }
        return M;
    }
}