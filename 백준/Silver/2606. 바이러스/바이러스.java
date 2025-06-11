import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static String line;
    static int i;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int computerPairCount = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> computerPair = new HashMap<>();

        for (int i = 0; i < computerPairCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());

            ArrayList<Integer> getNumber1 = computerPair.getOrDefault(number1, new ArrayList<>());
            getNumber1.add(number2);

            ArrayList<Integer> getNumber2 = computerPair.getOrDefault(number2, new ArrayList<>());
            getNumber2.add(number1);

            computerPair.put(number1, getNumber1);
            computerPair.put(number2, getNumber2);
        }

        if (!computerPair.containsKey(1)) {
            System.out.println(0);
            return;
        }

        boolean[] infection = new boolean[computer + 1]; // 감염 판단 배열
        infection[1] = true;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        int answer = 0;
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();

            ArrayList<Integer> numbers = computerPair.get(pop);
            for (Integer number : numbers) {
                if (infection[number]) {
                    continue;
                }
                answer++;
                infection[number] = true;
                deque.add(number);
            }
        }

        System.out.println(answer);
    }
}
