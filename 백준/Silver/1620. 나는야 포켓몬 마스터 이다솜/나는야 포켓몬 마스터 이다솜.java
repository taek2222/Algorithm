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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> illustration = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            illustration.put(String.valueOf(i), pokemon);
            illustration.put(pokemon, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String search = br.readLine();
            String find = illustration.get(search);
            bw.append(find).append("\n");
        }

        bw.flush();
    }
}
