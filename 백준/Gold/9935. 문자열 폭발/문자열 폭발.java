import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bl = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bl) {
                boolean match = true;
                for (int j = 0; j < bl; j++) {
                    if (sb.charAt(sb.length() - bl + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - bl, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}