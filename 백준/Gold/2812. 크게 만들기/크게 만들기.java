import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] numbers = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (char number : numbers) {
            while (!deque.isEmpty() && deque.getLast() < number && K != 0) {
                K--;
                deque.removeLast();
            }
            deque.addLast(number);
        }

        while (deque.size() > K) {
            bw.append(deque.removeFirst());
        }

        bw.flush();
    }
}
