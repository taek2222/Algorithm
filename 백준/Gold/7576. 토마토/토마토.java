import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[] directionX = {1, -1, 0, 0};
    static int[] directionY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<List<Integer>> tomatoDeque = new ArrayDeque<>();
        int[][] tomato = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    tomatoDeque.add(List.of(i, j));
                }
            }
        }

        int answer = -1;
        while (!tomatoDeque.isEmpty()) {
            answer++;

            int currentSize = tomatoDeque.size();
            for (; 0 < currentSize; currentSize--) {
                List<Integer> popTomato = tomatoDeque.pop();
                int x = popTomato.get(0);
                int y = popTomato.get(1);

                for (int i = 0; i < directionX.length; i++) {
                    int newX = x + directionX[i];
                    int newY = y + directionY[i];

                    if (newX < 0 || newY < 0 || newX >= M || newY >= N || tomato[newX][newY] == -1
                            || tomato[newX][newY] == 1) {
                        continue;
                    }
                    tomato[newX][newY] = 1;
                    tomatoDeque.add(List.of(newX, newY));
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
