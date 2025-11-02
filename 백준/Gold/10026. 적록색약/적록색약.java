import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] graph = new char[N][N];
        boolean[][] generalVisit = new boolean[N][N];
        boolean[][] medicineVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        int generalCount = 0;
        int medicineCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char currentColor = graph[i][j];
                if (!generalVisit[i][j]) {
                    processVisit(generalVisit, graph, new char[]{currentColor}, i, j);
                    generalCount++;
                }

                if (!medicineVisit[i][j]) {
                    if (currentColor == 'R' || currentColor == 'G') {
                        processVisit(medicineVisit, graph, new char[]{'R', 'G'}, i, j);
                    } else {
                        processVisit(medicineVisit, graph, new char[]{currentColor}, i, j);
                    }
                    medicineCount++;
                }
            }
        }

        System.out.println(generalCount + " " + medicineCount);
    }

    private static void processVisit(boolean[][] visit, char[][] graph, char[] colors, int posX, int posY) {
        visit[posX][posY] = true;

        for (int i = 0; i < dx.length; i++) {
            int nextX = posX + dx[i];
            int nextY = posY + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph.length || visit[nextX][nextY]) {
                continue;
            }

            if (!checkColorEquals(graph[nextX][nextY], colors)) {
                continue;
            }

            processVisit(visit, graph, colors, nextX, nextY);
        }
    }

    private static boolean checkColorEquals(char current, char[] colors) {
        for (char color : colors) {
            if (current == color) {
                return true;
            }
        }
        return false;
    }
}
