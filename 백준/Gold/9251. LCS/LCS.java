import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] answer = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    answer[i][j] = answer[i - 1][j - 1] + 1;
                } else {
                    answer[i][j] = Math.max(answer[i - 1][j], answer[i][j - 1]);
                }
            }
        }

        System.out.println(answer[str1.length()][str2.length()]);
    }
}
