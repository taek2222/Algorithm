import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> wardrobe = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String category = st.nextToken();

                if (!wardrobe.containsKey(category)) {
                    wardrobe.put(category, 0);
                }

                wardrobe.put(category, wardrobe.get(category) + 1);
            }

            int total = 1;
            for (Integer value : wardrobe.values()) {
                total *= (value + 1);
            }

            bw.append(String.valueOf(total - 1)).append("\n");
        }

        bw.flush();
    }
}
