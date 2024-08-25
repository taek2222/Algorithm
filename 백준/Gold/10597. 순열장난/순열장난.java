import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static boolean[] visited;
    private static String inputStr;
    private static int[] result;
    private static boolean solutionFound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputStr = br.readLine();
        solutionFound = false;

        // N 값 계산
        if (inputStr.length() < 10) {
            N = inputStr.length();
        } else {
            N = (inputStr.length() + 7) / 2 + 1;
        }

        visited = new boolean[N + 1];
        result = new int[N];

        // 순열 복원 시작
        restorePermutation(0, 0);
    }

    private static void restorePermutation(int charIndex, int resultIndex) {
        if (resultIndex == N) {
            printResult();
            solutionFound = true;
            return;
        }

        // 1자리 숫자 처리
        if (!solutionFound && isValidSingleDigit(charIndex)) {
            int num = inputStr.charAt(charIndex) - '0';
            placeNumberAndRecurse(charIndex + 1, resultIndex, num, 1);
        }

        // 2자리 숫자 처리
        if (!solutionFound && isValidDoubleDigit(charIndex)) {
            int num = Integer.parseInt(inputStr.substring(charIndex, charIndex + 2));
            placeNumberAndRecurse(charIndex + 2, resultIndex, num, 2);
        }
    }

    private static boolean isValidSingleDigit(int charIndex) {
        if (charIndex >= inputStr.length()) return false;
        int num = inputStr.charAt(charIndex) - '0';
        return num > 0 && num <= N && !visited[num];
    }

    private static boolean isValidDoubleDigit(int charIndex) {
        if (charIndex + 1 >= inputStr.length()) return false;
        int num = Integer.parseInt(inputStr.substring(charIndex, charIndex + 2));
        return num <= N && !visited[num];
    }

    private static void placeNumberAndRecurse(int nextCharIndex, int resultIndex, int num, int length) {
        visited[num] = true;
        result[resultIndex] = num;
        restorePermutation(nextCharIndex, resultIndex + 1);
        if (!solutionFound) { // 백트래킹
            visited[num] = false;
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i < result.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}