import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static String[] sign;
    static int k;
    static ArrayList<Integer> answer = new ArrayList<>();
    static Long min = Long.MAX_VALUE;
    static Long max = Long.MIN_VALUE;
    static String maxString, minString;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new String[k+1];
        sign[0] = "0";

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < k+1; i++)
            sign[i] = st.nextToken();
        
        backtracking(0, 0);

        System.out.println(maxString);
        System.out.println(minString);
    }
    
    private static void backtracking(int depth, int lastNum) {
        if(k + 1 == depth) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : answer)
                sb.append(integer);

            Long numbers = Long.parseLong(String.valueOf(sb));

            if(max < numbers) {
                max = numbers;
                maxString = sb.toString();
            }
            if(min > numbers) {
                min = numbers;
                minString = sb.toString();
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (answer.contains(i))
                continue;
            
            answer.add(i);
            
            switch (sign[depth]) {
                case ">" : if (lastNum > i) backtracking(depth + 1, i); break;
                case "<" : if (lastNum < i) backtracking(depth + 1, i); break;
                case "0" : backtracking(depth + 1, i);
            }
            
            answer.remove(depth);
        }
    }
}