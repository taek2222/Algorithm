import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Main {
    static HashSet<Integer> iSet;
    static HashSet<Integer> numberSet;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answer = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];

        for (int i = 1; i <= N; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if(answer.contains(i))
                continue;
            
            iSet = new HashSet<>(); numberSet = new HashSet<>();
            DFS(i, numbers);

            if(iSet.equals(numberSet)) {
                answer.addAll(iSet);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int integer : answer)
            System.out.println(integer);
    }

    private static void DFS(int i, int[] numbers) {
        if(iSet.contains(i))
            return;

        iSet.add(i);
        numberSet.add(numbers[i]);
        DFS(numbers[i], numbers);
    }
}