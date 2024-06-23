import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        for(int i = 0; i < number; i++) {
            String word = br.readLine();
            System.out.print(word.charAt(0)); // 첫번째 String index
            System.out.println(word.charAt(word.length()-1)); // 마지막 String index
        }
    }
}
