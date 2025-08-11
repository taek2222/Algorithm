import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static List<List<Integer>> graph;
    static boolean[] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N];

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String number = st.nextToken();
                if (number.equals("0")) {
                    continue;
                }

                List<Integer> value = graph.get(i);
                value.add(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flag = false;
                visit = new boolean[N];
                
                dfs(i, j);
                if (flag) {
                    sb.append("1 ");
                    continue;
                }
                sb.append("0 ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int i, int j) {
        List<Integer> values = graph.get(i);
        for (int value : values) {
            if (value == j) {
                flag = true;
            }

            if (visit[value]) {
                continue;
            }

            visit[value] = true;
            dfs(value, j);
        }
    }
}
