import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static int[][] fineDusts;
    public static int[][] airPurifierUpwardDirection = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int[][] airPurifierDownwardDirection = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        fineDusts = new int[R][C];
        ArrayList<Integer> airPurifierLocation = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int fineDustLevel = Integer.parseInt(st.nextToken());
                fineDusts[i][j] = fineDustLevel;
            }

            if (fineDusts[i][0] == -1)
                airPurifierLocation.add(i);
        }

        // 시간(초) 반복문
        for (int count = 0; count < T; count++) {
            // 확산
            fineDusts = processSpreadOfFineDust(R, C);

            // 공기 청정기
            processAirPurifier(airPurifierUpwardDirection, 0, airPurifierLocation.get(0), C, airPurifierLocation.get(0));
            processAirPurifier(airPurifierDownwardDirection, airPurifierLocation.get(1), R - 1, C, airPurifierLocation.get(1));
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (fineDusts[i][j] == -1)
                    continue;

                answer += fineDusts[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void processAirPurifier(int[][] directions, int minX, int maxX, int maxY, int posX) {
        // 공기청정기 위치
        int posY = 0;
        int airPurifierX = posX;
        int airPurifierY = 0;

        for (int[] direction : directions) {
            while (true) {
                int nextX = posX + direction[0];
                int nextY = posY + direction[1];

                if (posX + direction[0] < minX || posX + direction[0] > maxX || posY + direction[1] < 0 || posY + direction[1] >= maxY)
                    break;

                if (fineDusts[posX][posY] != -1) {
                    if (fineDusts[nextX][nextY] == -1)
                        fineDusts[posX][posY] = 0;
                    else
                        fineDusts[posX][posY] = fineDusts[nextX][nextY];
                }

                posX = nextX;
                posY = nextY;
            }

            if (posX == airPurifierX && posY == airPurifierY) {
                break;
            }
        }
    }

    private static int[][] processSpreadOfFineDust(int r, int c) {
        int[][] spreadOfFineDust = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int fineDustLevel = fineDusts[i][j];
                if (fineDustLevel < 5) {
                    if (fineDustLevel == -1) {
                        spreadOfFineDust[i][j] = -1;
                    } else {
                        spreadOfFineDust[i][j] += fineDustLevel;
                    }
                    continue;
                }

                int spreadFigure = fineDustLevel / 5;
                for (int[] direction : directions) {
                    int X = i + direction[0];
                    int Y = j + direction[1];

                    if (X > -1 && X < r && Y > -1 && Y < c && fineDusts[X][Y] != -1) {
                        spreadOfFineDust[X][Y] += spreadFigure;
                        fineDustLevel -= spreadFigure;
                    }
                }
                spreadOfFineDust[i][j] += fineDustLevel;
            }
        }

        return spreadOfFineDust;
    }
}