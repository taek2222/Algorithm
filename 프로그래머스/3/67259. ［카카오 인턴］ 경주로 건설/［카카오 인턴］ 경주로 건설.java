import java.util.ArrayDeque;

class Solution {
    private static class Node {
        int x, y, direction, cost;

        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }

    // 상하좌우 방향 (0, -1), (-1, 0), (0, 1), (1, 0) 순서로 교체에 필요.
    private static final int[] rx = {0, -1, 0, 1};
    private static final int[] ry = {-1, 0, 1, 0};
    private static int N;
    private static int[][][] visited;

    // 주어진 좌표가 보드의 범위 내에 있는지 확인
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    // 주어진 좌표가 차단되었거나 이동할 수 없는지 확인
    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }

    // 이전 방향과 현재 방향에 따라 비용 계산
    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }

    // 주어진 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우에 갱신
    private static boolean shouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }

    public int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                answer = Math.min(answer, now.cost);
            }

            for (int i = 0; i < 4; i++) {
                int newX = now.x + rx[i];
                int newY = now.y + ry[i];

                if (isBlocked(board, newX, newY)) {
                    continue;
                }

                int newCost = calculateCost(i, now.direction, now.cost);
                if (shouldUpdate(newX, newY, i, newCost)) {
                    queue.add(new Node(newX, newY, i, newCost));
                    visited[newX][newY][i] = newCost;
                }
            }
        }
        return answer;
    }
}