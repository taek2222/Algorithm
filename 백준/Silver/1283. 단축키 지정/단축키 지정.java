import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    
    static boolean[] alphabets = new boolean[26];
    static char alphabet;
    static Integer pos = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int count = 0; count < n; count++) {
            String option = br.readLine();
            findCommandPos(option);

            alphabets[alphabet - 65] = true;
            if (pos == null) {
                sb.append(option).append("\n");
                continue;
            }

            StringBuilder wrap = new StringBuilder(option);
            wrap.insert(pos, "[");
            wrap.insert(pos + 2, "]");

            sb.append(wrap).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void findCommandPos(final String option) {
        pos = null;
        String[] split = option.split(" ");
        for (String s : split) {
            char findAlphabet = s.toUpperCase().charAt(0);

            if (!alphabets[findAlphabet-65]) {
                alphabet = findAlphabet;
                pos = option.indexOf(s);
                return;
            }
        }

        char[] charArray = option.toUpperCase().toCharArray();
        for (int index = 0; index < option.length(); index++) {
            if (charArray[index] == ' ') {
                continue;
            }

            if (!alphabets[charArray[index]-65]) {
                alphabet = charArray[index];
                pos = index;
                return;
            }
        }
    }
}