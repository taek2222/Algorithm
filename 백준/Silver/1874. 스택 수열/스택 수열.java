import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 1;
        stack.add(0);
        stack.add(index++);
        sb.append("+").append("\n");

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            while (stack.peek() != number) {
                if (stack.peek() < number) {
                    if (index > n) {
                        System.out.println("NO");
                        System.exit(0);
                    }
                    stack.add(index++);
                    sb.append("+").append("\n");
                } else {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}