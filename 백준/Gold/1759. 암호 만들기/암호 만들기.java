import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int L;
    static int C;
    static String[] strings;
    static String[] saveString;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        saveString = new String[L];

        strings = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++)
            strings[i] = st.nextToken();
        Arrays.sort(strings);

        for(int i = 0; i <= C - L; i++) {
            saveString[0] = strings[i];
            DFS(i + 1, 1);
        }

        if (sb.charAt(sb.length() - 1) == '\n')
            sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }

    private static void DFS(int idx, int depth) {
        if (depth == L) {
            stringCheck();
            return;
        }

        for (int i = idx; i < strings.length; i++) {
            saveString[depth] = strings[i];
            DFS(i + 1, depth + 1);
        }
    }

    private static void stringCheck() {
        int consonants = 0; // 자음
        int vowels = 0; // 모음

        for (String s : saveString) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
                vowels++;
            else consonants++;
        }

        if (consonants > 1 && vowels > 0) {
            for (String s : saveString)
                sb.append(s);
            sb.append("\n");
        }
    }
}