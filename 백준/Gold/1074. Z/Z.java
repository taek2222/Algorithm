import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Deque<int[]> ZArray = new ArrayDeque<>();
        ZArray.add(new int[]{0, 0, (int) Math.pow(2, N), (int) Math.pow(2, N), 0});

        int answer = 0;
        int[] nextPos;

        for (int i = 0; i < N; i++) {
            int[] z = ZArray.pop();

            int weight = (z[2] - z[0]) * (z[3] - z[1]);
            answer += weight * z[4];

            if (i == N - 1) {
                ZArray.add(z);
                break;
            }

            int nextX = z[0] + z[2];
            int nextY = z[1] + z[3];
            nextPos = new int[]{z[0], z[1], nextX / 2, nextY / 2, 0};
            if (nextPos[0] <= r && nextPos[2] > r && nextPos[1] <= c && nextPos[3] > c) {
                ZArray.add(nextPos);
                continue;
            }

            nextPos = new int[]{z[0], nextY / 2, nextX / 2, z[3], 1};
            if (nextPos[0] <= r && nextPos[2] > r && nextPos[1] <= c && nextPos[3] > c) {
                ZArray.add(nextPos);
                continue;
            }

            nextPos = new int[]{nextX / 2, z[1], z[2], nextY / 2, 2};
            if (nextPos[0] <= r && nextPos[2] > r && nextPos[1] <= c && nextPos[3] > c) {
                ZArray.add(nextPos);
                continue;
            }

            nextPos = new int[]{nextX / 2, nextY / 2, z[2], z[3], 3};
            if (nextPos[0] <= r && nextPos[2] > r && nextPos[1] <= c && nextPos[3] > c) {
                ZArray.add(nextPos);
            }
        }

        int[] pop = ZArray.pop();

        if (pop[0] == r && pop[1] == c) {
            answer += 0;
        } else if (pop[0] == r && pop[1] + 1 == c) {
            answer += 1;
        } else if (pop[0] + 1 == r && pop[1] == c) {
            answer += 2;
        } else if (pop[0] + 1 == r && pop[1] + 1 == c) {
            answer += 3;
        }

        System.out.println(answer);
    }
}
