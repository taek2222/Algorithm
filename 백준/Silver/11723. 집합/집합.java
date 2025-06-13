import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static Set<Integer> S;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = new HashSet<>();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (!st.hasMoreElements()) {
                if (command.equals("all")) {
                    commandAll();
                    continue;
                }

                if (command.equals("empty")) {
                    commandEmpty();
                    continue;
                }
            }

            int x = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                commandAdd(x);
                continue;
            }

            if (command.equals("remove")) {
                commandRemove(x);
                continue;
            }

            if (command.equals("check")) {
                commandCheck(x);
                continue;
            }

            if (command.equals("toggle")) {
                commandToggle(x);
            }
        }

        bw.flush();
    }

    private static void commandAdd(int x) {
        S.add(x);
    }

    private static void commandRemove(int x) {
        S.remove(x);
    }

    private static void commandCheck(int x) throws IOException {
        if (S.contains(x)) {
            bw.append("1").append("\n");
        } else {
            bw.append("0").append("\n");
        }
    }

    private static void commandToggle(int x) {
        if (S.contains(x)) {
            commandRemove(x);
        } else {
            commandAdd(x);
        }
    }

    private static void commandAll() {
        Set<Integer> conversion = new HashSet<>(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        S = conversion;
    }

    private static void commandEmpty() {
        S.clear();
    }
}
