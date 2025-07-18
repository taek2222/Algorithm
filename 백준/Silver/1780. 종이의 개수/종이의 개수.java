import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static class Paper {
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Paper(final int startX, final int startY, final int endX, final int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        for (int i = 0; i < papers.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < papers[0].length; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Paper> deque = new ArrayDeque<>();
        deque.add(new Paper(0, 0, N, N));

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;

        while (!deque.isEmpty()) {
            Paper current = deque.pop();

            if (condition(current)) {
                int value = papers[current.startX][current.startY];
                if (value == -1) {
                    answer1++;
                }

                if (value == 0) {
                    answer2++;
                }

                if (value == 1) {
                    answer3++;
                }
                continue;
            }

            int dividing = (current.endX - current.startX) / 3;

            for (int i = 0; i < 3; i++) {
                int startPosY = current.startY + (dividing * i);
                int endPosY = current.startY + (dividing * (i + 1));
                for (int j = 0; j < 3; j++) {
                    int startPosX = current.startX + (dividing * j);
                    int endPosX = current.startX + (dividing * (j + 1));
                    deque.add(new Paper(startPosX, startPosY, endPosX, endPosY));
                }
            }
        }
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    private static boolean condition(Paper paper) {
        int target = papers[paper.startX][paper.startY];
        for (int i = paper.startX; i < paper.endX; i++) {
            for (int j = paper.startY; j < paper.endY; j++) {
                if (target != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
