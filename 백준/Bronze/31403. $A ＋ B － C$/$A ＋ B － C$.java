import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int total = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);

        System.out.println(total);
        System.out.println(Integer.parseInt(A + B) - Integer.parseInt(C));
    }
}
