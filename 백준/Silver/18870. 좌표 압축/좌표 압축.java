import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, String> answer = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> originNumbers = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            originNumbers.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> sortNumbers = new ArrayList<>(originNumbers);
        Collections.sort(sortNumbers);

        int i = 0;
        for (Integer sortNumber : sortNumbers) {
            if (answer.containsKey(sortNumber)) {
                continue;
            }
            answer.put(sortNumber, String.valueOf(i));
            i++;
        }

        for (int originNumber : originNumbers) {
            bw.append(answer.get(originNumber)).append(" ");
        }

        bw.flush();
    }
}
