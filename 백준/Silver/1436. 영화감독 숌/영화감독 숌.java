import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 0;
        
        while (true) {
            String valueOf = String.valueOf(i);
            if (valueOf.contains("666")) {
                count++;
                if (count == N) {
                    break;
                }
            }
            i++;
        }
        System.out.println(i);

        br.close();
    }
}
