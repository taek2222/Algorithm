import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<int[]> visitQueue = new ArrayDeque<>();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] cheese = new int[M][N];
        boolean[][] visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == M - 1 || j == N - 1) {
                    visitQueue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        ArrayDeque<int[]> cheeseQueue = new ArrayDeque<>();
        int[] curM = new int[] {1, -1, 0, 0};
        int[] curN = new int[] {0, 0, 1, -1};
        int m, n, nextM, nextN;
        int lastCheese = 0, day = 0;

        while (true) {
            while (!visitQueue.isEmpty()) {
                int[] pop = visitQueue.poll();
                m = pop[0];
                n = pop[1];

                for (int i = 0; i < 4; i++) {
                    nextM = m + curM[i];
                    nextN = n + curN[i];
                    if(nextM > 0 && nextN > 0 && nextM < M && nextN < N && !visit[nextM][nextN]) {
                        visit[nextM][nextN] = true;

                        if(cheese[nextM][nextN] == 0)
                            visitQueue.add(new int[]{nextM, nextN});
                        else
                            cheeseQueue.add(new int[]{nextM, nextN});
                    }
                }
            }

            if (cheeseQueue.isEmpty())
                break;

            lastCheese = cheeseQueue.size();
            day++;

            visitQueue = cheeseQueue.clone();
            cheeseQueue.clear();
        }

        System.out.println(day);
        System.out.println(lastCheese);
    }
}