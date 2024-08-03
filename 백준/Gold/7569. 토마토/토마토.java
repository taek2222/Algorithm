import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        // 2 3 5
        int[][][] array = new int[H][N][M];

        for (int h = 0; h < H; h++)
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    array[h][n][m] = Integer.parseInt(st.nextToken());
                    if (array[h][n][m] == 1)
                        arrayDeque.add(new int[]{h, n, m});
                }
            }

        int[] curH = {1, -1, 0, 0, 0, 0};
        int[] curN = {0, 0, 1, -1, 0, 0};
        int[] curM = {0, 0, 0, 0, 1, -1};
        int answer = 0;

        while (!arrayDeque.isEmpty()) {
            for (int length = 0, size = arrayDeque.size(); length < size; length++) {
                int[] pop = arrayDeque.pop();
                int hn = pop[0];
                int nn = pop[1];
                int mn = pop[2];

                for (int i = 0; i < curH.length; i++) {
                    int nextH = hn + curH[i];
                    int nextN = nn + curN[i];
                    int nextM = mn + curM[i];
                    if (nextH >= 0 && nextH < H && nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && array[nextH][nextN][nextM] == 0) {
                        array[nextH][nextN][nextM] = 1;
                        arrayDeque.add(new int[]{nextH, nextN, nextM});
                    }
                }
            }
            if (!arrayDeque.isEmpty())
                answer++;
        }

        for (int h = 0; h < H; h++)
            for (int n = 0; n < N; n++)
                for (int m = 0; m < M; m++)
                    if(array[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }

        System.out.println(answer);
    }
}