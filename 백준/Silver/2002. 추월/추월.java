import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 예제 입력
 * 4
 * ZG431SN
 * ZG5080K
 * ST123D
 * ZG206A
 * ZG206A
 * ZG431SN
 * ZG5080K
 * ST123D
 *
 * 예제 출력
 * 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++)
            linkedHashSet.add(br.readLine());


        while(!linkedHashSet.isEmpty()) {
            Iterator<String> iterator = linkedHashSet.iterator();
            String car = iterator.next();
            while (true) {
                String outCar = br.readLine();
                linkedHashSet.remove(outCar);
                if(car.equals(outCar))
                    break;
                else
                    answer++;
            }
        }

        System.out.println(answer);
    }
}