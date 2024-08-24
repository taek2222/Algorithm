import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS("");
    }

    private static void DFS(String s) {
        if (s.length() == N) {
            System.out.println(s);
            System.exit(0);
        }

        for (int i = 1; i < 4; i++) {
            if (check(s + i))
                DFS(s + i);
        }
    }

    private static boolean check(String s) {
        int length = s.length() / 2;

        for (int i = 1; i <= length; i++) {
            if (isEquals(s, i))
                return false;
        }

        return true;
    }

    private static boolean isEquals(String s, int i) {
        return s.substring(s.length() - i).equals(s.substring(s.length() - i * 2, s.length() - i));
    }
}