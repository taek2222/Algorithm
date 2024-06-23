import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N3052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number, remain;
        ArrayList<Integer> remain_number= new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            number = Integer.parseInt(br.readLine());
            remain = number % 42;

            if(!remain_number.contains(remain))
                remain_number.add(remain);
        }

        System.out.println(remain_number.size());
    }
}
