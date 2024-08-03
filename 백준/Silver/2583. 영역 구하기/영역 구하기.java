import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] numberArray = new boolean[N][M];

        int x1, x2, y1, y2;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++)
                for (int k = y1; k < y2; k++)
                    numberArray[j][k] = true;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[N][M];
        int area; // 영역 갯수
        int areaCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j] || numberArray[i][j])
                    continue;

                areaCount++;
                area = 0;
                ArrayDeque<int[]> bfsDeque = new ArrayDeque<>();
                bfsDeque.add(new int[]{i, j});

                while (!bfsDeque.isEmpty()) {
                    int[] pop = bfsDeque.pop();

                    int x = pop[0];
                    int y = pop[1];

                    if(visit[x][y] || numberArray[x][y])
                        continue;

                    visit[x][y] = true;
                    area++;

                    if (x > 0)
                        bfsDeque.add(new int[]{x - 1, y});
                    if (y > 0)
                        bfsDeque.add(new int[]{x, y - 1});
                    if (x != N-1)
                        bfsDeque.add(new int[]{x + 1, y});
                    if (y != M-1)
                        bfsDeque.add(new int[]{x, y + 1});
                }

                answer.add(area);
            }
        }
        Collections.sort(answer);

        System.out.println(areaCount);

        for (Integer integer : answer)
            System.out.print(integer + " ");
    }
}