import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static int[] directionX = new int[]{1, -1, 0, 0};
    static int[] directionY = new int[]{0, 0, 1, -1};

    static class Node {
        private int x;
        private int y;
        private boolean wallBreak;
        private int count;

        public Node(final int x, final int y, final boolean wallBreak, final int count) {
            this.x = x;
            this.y = y;
            this.wallBreak = wallBreak;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] visit = new boolean[N][M];
        boolean[][] wallVisit = new boolean[N][M];

        Deque<Node> nodes = new ArrayDeque<>();
        nodes.add(new Node(0, 0, true, 1));

        while (!nodes.isEmpty()) {
            Node node = nodes.pop();

            if (node.x == N - 1 && node.y == M - 1) {
                System.out.println(node.count);
                return;
            }

            for (int i = 0; i < directionY.length; i++) {
                int nextX = node.x + directionX[i];
                int nextY = node.y + directionY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (map[nextX][nextY] == '1') { // 벽이 존재
                    if (node.wallBreak && !wallVisit[nextX][nextY]) {
                        Node newNode = new Node(nextX, nextY, false, node.count + 1);
                        wallVisit[nextX][nextY] = true;
                        nodes.add(newNode);
                    }
                } else if (node.wallBreak && !visit[nextX][nextY]) {
                    Node newNode = new Node(nextX, nextY, true, node.count + 1);
                    visit[nextX][nextY] = true;
                    nodes.add(newNode);
                } else if (!node.wallBreak && !wallVisit[nextX][nextY]) {
                    Node newNode = new Node(nextX, nextY, false, node.count + 1);
                    wallVisit[nextX][nextY] = true;
                    nodes.add(newNode);
                }
            }
        }
        System.out.println("-1");
    }
}
