import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> number = new ArrayList<>();

        int range = Integer.parseInt(br.readLine());

        if(range % 2 == 0) {
            for (int i = 2; i <= range; i += 2)
                number.add(i);
        }
        else {
            number.add(range);
            for (int i = 2; i < range; i += 2)
                number.add(i);
        }
        System.out.println("생성 완료");

        for (int i = 2; i < number.size(); i += 2) {
            number.add(number.get(i-1));
        }

        System.out.println(number.get(number.size()-1));
    }
}
