import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        int[] number = new int[26];

        char[] str = br.readLine().toUpperCase().toCharArray();

        for (char ch : str)
            number[ch - 'A']++;

        int maxindex = 0, max = number[0];

        for (int i = 1; i < number.length; i++)
            if (max < number[i]) {
                max = number[i];
                maxindex = i;
            }

        for (int j : number)
            if (max == j)
                check++;

        if (check > 1)
            System.out.println("?");
        else
            System.out.println((char)(maxindex + 65));
    }
}
