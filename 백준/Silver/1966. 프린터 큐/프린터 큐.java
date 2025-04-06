import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Main {

    public static Queue<Print> queue;

    public static class Print implements Comparable<Print> {

        public final int priority;
        public final int index;

        public Print(final int priority, final int index) {
            this.priority = priority;
            this.index = index;
        }

        @Override
        public int compareTo(final Print o) {
            return Integer.compare(this.priority, o.priority);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            queue = new ArrayDeque<>();
            String[] priorities = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                Print newPrint = new Print(Integer.parseInt(priorities[j]), j);
                queue.add(newPrint);
            }

            int count = 0;
            while (true) {
                Print current = queue.poll();

                if (isMax(current)) {
                    count++;
                    if (current.index == M) {
                        bw.append(count + "\n");
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }

        br.close();
        bw.close();
    }

    public static boolean isMax(final Print current) {
        for (Print print : queue) {
            if (current.compareTo(print) < 0) {
                return false;
            }
        }
        return true;
    }
}
