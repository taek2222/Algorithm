import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<Integer, String> changeMap = new HashMap<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        int K = Integer.parseInt(st.nextToken()); // 최대 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 학생들이 버튼을 클릭한 횟수

        for(int i = 0; i < L; i++) {
            String studentId = br.readLine();
            hashMap.put(studentId, i);
        }

        hashMap.forEach((key, value) -> {
            numbers.add(value);
            changeMap.put(value, key);
        });

        int[] number = numbers.stream().mapToInt(i -> i).toArray();
        Arrays.sort(number);

        int range = Math.min(K, number.length);

        for (int i = 0; i < range; i++) {
            System.out.println(changeMap.get(number[i]));
        }
    }
}