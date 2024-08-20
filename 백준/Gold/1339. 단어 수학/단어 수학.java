import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = st.length; j > 0; j--) {
                int number = 0;
                if (hashMap.containsKey(st[st.length - j]))
                    number = hashMap.get(st[st.length - j]);

                hashMap.put(st[st.length - j], (int) (number + Math.pow(10, j-1)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>(hashMap.values());
        list.sort(Collections.reverseOrder());

        int g = 9;
        int answer = 0;
        for (Integer integer : list) {
            answer += integer * g;
            g--;
        }

        System.out.println(answer);
    }
}
