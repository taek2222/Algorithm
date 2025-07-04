import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (65 <= charAt && charAt <= 90) {
                sb.append(charAt);
            } else if (charAt == '(') {
                stack.add('S');
            } else if (charAt == ')') {
                while (true) {
                    char pop = stack.pop();
                    if (pop == 'S') {
                        break;
                    }
                    sb.append(pop);
                }
            } else {
                while (!stack.isEmpty()) {
                    char last = stack.peek();
                    if (opinion(last) < opinion(charAt)) {
                        break;
                    }
                    char pop = stack.pop();
                    sb.append(pop);
                }

                stack.add(charAt);
            }
        }

        while (!stack.isEmpty()) {
            char pop = stack.pop();
            sb.append(pop);
        }

        System.out.println(sb);
    }

    private static int opinion(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
