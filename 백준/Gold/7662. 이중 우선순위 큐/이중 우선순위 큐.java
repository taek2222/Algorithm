import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> deque = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                String character = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (character.equals("I")) {
                    deque.put(n, deque.getOrDefault(n, 0) + 1);
                }

                if (character.equals("D") && !deque.isEmpty()) {
                    int key;
                    if (n == 1) {
                        key = deque.lastKey();
                    } else {
                        key = deque.firstKey();
                    }

                    if (deque.get(key) > 1) {
                        deque.put(key, deque.get(key) - 1);
                    } else {
                        deque.remove(key);
                    }
                }
            }

            if (deque.isEmpty()) {
                bw.append("EMPTY").append("\n");
            } else {
                bw.append(deque.lastKey().toString()).append(" ")
                        .append(deque.firstKey().toString()).append("\n");
            }
        }

        bw.flush();
    }
}
