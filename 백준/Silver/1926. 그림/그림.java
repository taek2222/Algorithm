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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][m+1];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) { // 그래프 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<int[]> arrayDeque;
        int graphTotal = 0;
        int areaMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0 || visit[i][j])
                    continue;

                graphTotal++;

                int area = 0;
                arrayDeque = new ArrayDeque<>();
                arrayDeque.add(new int[]{i, j});

                while (!arrayDeque.isEmpty()) {
                    int[] pop = arrayDeque.pop();

                    if(graph[pop[0]][pop[1]] == 0 || visit[pop[0]][pop[1]])
                        continue;

                    area++;
                    visit[pop[0]][pop[1]] = true;

                    if(pop[1] != 0)
                        arrayDeque.add(new int[]{pop[0], pop[1] - 1});
                    if(pop[0] != 0)
                        arrayDeque.add(new int[]{pop[0] - 1, pop[1]});

                    arrayDeque.add(new int[]{pop[0] + 1, pop[1]});
                    arrayDeque.add(new int[]{pop[0], pop[1] + 1});

                }

                if(areaMax < area)
                    areaMax = area;
            }
        }

        System.out.println(graphTotal);
        System.out.println(areaMax);
    }
}