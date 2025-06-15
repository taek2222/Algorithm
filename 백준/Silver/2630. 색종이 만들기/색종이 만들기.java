import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<int[]> separation = new ArrayDeque<>();
        separation.add(new int[]{0, 0, N, N});

        int white = 0;
        int blue = 0;
        while (!separation.isEmpty()) {
            int[] paper = separation.pop();

            int result = verification(paper[0], paper[1], paper[2], paper[3]);

            if (result == -1) {
                int x = paper[0] + paper[2];
                int y = paper[1] + paper[3];
                separation.add(new int[]{paper[0], paper[1], x / 2, y / 2});
                separation.add(new int[]{paper[0], y / 2, x / 2, paper[3]});
                separation.add(new int[]{x / 2, paper[1], paper[2], y / 2});
                separation.add(new int[]{x / 2, y / 2, paper[2], paper[3]});
                continue;
            }

            if (result == 1) {
                blue++;
            } else {
                white++;
            }
        }

        System.out.println(white);
        System.out.println(blue);
    }

    private static int verification(int startX, int startY, int endX, int endY) {
        int startPaper = papers[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                int paper = papers[i][j];
                if (paper != startPaper) {
                    return -1;
                }
            }
        }

        return startPaper;
    }
}
