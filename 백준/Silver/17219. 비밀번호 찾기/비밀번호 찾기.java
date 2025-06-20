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

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String webSite = st.nextToken();
            String password = st.nextToken();

            passwords.put(webSite, password);
        }

        for (int i = 0; i < M; i++) {
            String webSite = br.readLine();
            String password = passwords.get(webSite);

            bw.append(password).append("\n");
        }

        bw.flush();
    }
}
