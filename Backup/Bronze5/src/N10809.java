import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class N10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        String S = br.readLine();

        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if(arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        for(int val : arr) {
            System.out.print(val + " ");
        }
    }
}