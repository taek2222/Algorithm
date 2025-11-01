import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        private int nextPos;
        private int weighted;

        public Node(final int nextPos, final int weighted) {
            this.nextPos = nextPos;
            this.weighted = weighted;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            friends.get(f1).add(f2);
            friends.get(f2).add(f1);
        }

        List<Integer> answers = new ArrayList<>();
        // 1. 한 사람씩 전체 순환
        for (int i = 1; i <= N; i++) {
            List<Integer> kevinBacons = new ArrayList<>();
            // 2. 한 사람씩 케빈 베이컨 구하기
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                int kevinBacon = 0;
                boolean flag = false;

                boolean[] visit = new boolean[N + 1];
                visit[i] = true;
                Deque<Node> deque = new ArrayDeque<>();
                deque.add(new Node(i, 1));
                while (!deque.isEmpty()) {
                    Node current = deque.pop();

                    List<Integer> nextPositions = friends.get(current.nextPos);
                    for (int nextPosition : nextPositions) {
                        if (nextPosition == j) {
                            kevinBacon = current.weighted;
                            flag = true;
                            break;
                        }

                        if (visit[nextPosition]) {
                            continue;
                        }
                        visit[nextPosition] = true;
                        deque.add(new Node(nextPosition, current.weighted + 1));
                    }

                    if (flag) {
                        break;
                    }
                }

                kevinBacons.add(kevinBacon);
            }

            int total = 0;
            for (int kevinBacon : kevinBacons) {
                total += kevinBacon;
            }

            answers.add(total);
        }

        int answer = 0;
        for (int i = 1; i < answers.size(); i++) {
            if (answers.get(answer) > answers.get(i)) {
                answer = i;
            }
        }

        System.out.println(answer + 1);
    }
}
