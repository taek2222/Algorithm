import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        int total = n1 * n2 * n3;

        int intArray[] = new int[10];
        Arrays.fill(intArray, 0);

        String temp = Integer.toString(total);
        int[] total_ = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
            total_[i] = temp.charAt(i) - '0';

        for(int i = 0, position; i < temp.length(); i++) {
            intArray[total_[i]]++;
        }
        for(int i = 0; i < intArray.length; i++)
            System.out.println(intArray[i]);
    }
}
