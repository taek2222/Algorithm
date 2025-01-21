import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = makeA(N, br);
        int day = 0;

        while (true) {
            boolean active = false;
            int[][] ACopy = new int[N][N];
            boolean[][] visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) { // 이미 방문 체크
                        continue;
                    }

                    ArrayList<int[]> federations = new ArrayList<>();
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.add(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        int[] position = deque.pop();
                        if (visit[position[0]][position[1]])
                            continue;

                        visit[position[0]][position[1]] = true;
                        federations.add(position);

                        for (int[] direction : directions) {
                            int newPosX = position[0] + direction[0];
                            int newPosY = position[1] + direction[1];

                            if (newPosX >= 0 && newPosX < N && newPosY >= 0 && newPosY < N && !visit[newPosX][newPosY]) {
                                int value = Math.abs(A[newPosX][newPosY] - A[position[0]][position[1]]);
                                if (value >= L && value <= R)
                                    deque.add(new int[]{newPosX, newPosY});
                            }
                        }
                    }

                    if (federations.size() > 1)
                        active = true;

                    int sum = 0;
                    for (int[] federation : federations) {
                        sum += A[federation[0]][federation[1]];
                    }

                    int value = sum / federations.size();
                    for (int[] federation : federations) {
                        ACopy[federation[0]][federation[1]] = value;
                    }
                }
            }

            A = ACopy;
            if (!active) {
                break;
            }
            day++;
        }

        System.out.println(day);
    }

    private static int[][] makeA(int N, BufferedReader br) throws IOException {
        StringTokenizer st;

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return A;
    }
}