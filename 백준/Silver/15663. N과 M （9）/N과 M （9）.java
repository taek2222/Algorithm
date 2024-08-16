import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static boolean[] visit;
    static HashSet<String> hashSet;
    static int N, M;
    static String[] str;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        hashSet = new LinkedHashSet<>();

        str = br.readLine().split(" ");

        numbers = new int[str.length];

        for (int i = 0; i < str.length; i++)
            numbers[i] = Integer.parseInt(str[i]);
        Arrays.sort(numbers);

        for (int i = 0; i < str.length; i++)
            str[i] = String.valueOf(numbers[i]);

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            backtracking(1, str[i]);
            visit[i] = false;
        }

        for (String s : hashSet)
            System.out.println(s);
    }

    private static void backtracking(int depth, String next) {
        if (depth == M) {
            hashSet.add(next);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            backtracking(depth+1, next + " " + str[i]);
            visit[i] = false;
        }
    }
}