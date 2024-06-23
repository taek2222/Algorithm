import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> number = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());

        for(int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0)
                number.remove(number.size()-1);
            else
                number.add(num);
        }

        int total = 0;

        for (Integer integer : number) total += integer;

        System.out.println(total);
    }
}
