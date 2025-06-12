import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static class Register {
        private String command;
        private int number;

        public Register(final String command, final int number) {
            this.command = command;
            this.number = number;
        }

        public Register copy() {
            return new Register(command, number);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Register answer = bfs(A, B);
            bw.append(answer.command).append("\n");
        }

        bw.flush();
    }

    private static Register bfs(int current, int target) {
        Deque<Register> registerDeque = new ArrayDeque<>();
        boolean[] visit = new boolean[10000];

        Register initialValue = new Register("", current);
        registerDeque.add(initialValue);

        while (!registerDeque.isEmpty()) {
            Register register = registerDeque.pop();

            if (register.number == target) {
                return register;
            }

            if (visit[register.number]) {
                continue;
            }

            visit[register.number] = true;

            registerDeque.add(commandD(register.copy()));
            registerDeque.add(commandS(register.copy()));
            registerDeque.add(commandL(register.copy()));
            registerDeque.add(commandR(register.copy()));
        }

        return null;
    }

    private static Register commandD(Register register) {
        register.number *= 2;

        if (register.number > 9999) {
            register.number %= 10000;
        }

        register.command += "D";

        return register;
    }

    private static Register commandS(Register register) {
        if (register.number == 0) {
            register.number = 9999;
        } else {
            register.number -= 1;
        }

        register.command += "S";
        return register;
    }

    private static Register commandL(Register register) {
        int number = register.number;

        int d1 = number / 1000;
        register.number = ((number % 1000) * 10) + d1;
        register.command += "L";

        return register;
    }

    private static Register commandR(Register register) {
        int number = register.number;

        int d4 = number % 10;
        register.number = (d4 * 1000) + (number / 10);
        register.command += "R";
        return register;
    }
}
