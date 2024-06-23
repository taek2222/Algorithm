import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[Integer.parseInt(br.readLine())];
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(br.readLine());
        Arrays.sort(array);
        for(int i : array)
            str.append(i).append("\n");
        System.out.print(str);
    }
}