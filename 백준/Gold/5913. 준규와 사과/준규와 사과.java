import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static boolean[][] earth;
    static boolean[][] visit;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        earth = new boolean[5][5];
        visit = new boolean[5][5];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            earth[x-1][y-1] = true;
        }

        visit[0][0] = true;
        visit[4][4] = true;
        DFS(new Node(0, 0), new Node(4, 4), 23-K);

        System.out.println(answer);
    }

    public static void DFS(Node jPos, Node hPos, int appleCount) {
        if(jPos.x == hPos.x && jPos.y == hPos.y) {
            if(appleCount < 1)
                answer++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextJx = jPos.x + dx[i];
            int nextJy = jPos.y + dy[i];

            for (int j = 0; j < 4; j++) {
                int nextHx = hPos.x + dx[j];
                int nextHy = hPos.y + dy[j];

                if (isaBoolean(nextJx, nextHx, nextJy, nextHy)) {
                    visit[nextJx][nextJy] = true;
                    visit[nextHx][nextHy] = true;

                    DFS(new Node(nextJx, nextJy), new Node(nextHx, nextHy), appleCount - 2);

                    visit[nextJx][nextJy] = false;
                    visit[nextHx][nextHy] = false;
                }
            }
        }
    }

    private static boolean isaBoolean(int nextJx, int nextHx, int nextJy, int nextHy) {
        return nextJx >= 0 && nextHx >= 0 && nextJy >= 0 && nextHy >= 0 && nextHx < 5 && nextHy < 5 && nextJx < 5 && nextJy < 5 && !earth[nextJx][nextJy] && !earth[nextHx][nextHy] && !visit[nextJx][nextJy] && !visit[nextHx][nextHy];
    }
}