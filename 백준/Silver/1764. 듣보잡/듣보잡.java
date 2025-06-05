import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (names.contains(name)) {
                list.add(name);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
