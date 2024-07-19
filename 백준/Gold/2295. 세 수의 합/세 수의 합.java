import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 예제 입력
 * 5
 * 2
 * 3
 * 5
 * 10
 * 18
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> numbers = new HashSet<>();
        HashSet<Integer> numbersSum = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++)
            numbers.add(Integer.parseInt(br.readLine()));

        List<Integer> numberArray = numbers.stream().collect(Collectors.toList());

        for(int num1 : numberArray)
            for(int num2 : numberArray)
                numbersSum.add(num1+num2);

        int max = 0;

        for(int num1 : numberArray)
            for (int num2 : numberArray) {
                int searchNumber = num1 - num2;
                if (numbersSum.contains(searchNumber))
                    if(max < num1)
                        max = num1;
            }

        System.out.println(max);
    }
}