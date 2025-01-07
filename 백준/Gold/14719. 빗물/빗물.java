import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputInit = br.readLine().split(" ");
        int h = Integer.parseInt(inputInit[0]);
        int w = Integer.parseInt(inputInit[1]);
        int[] numbers = new int[w];

        String[] inputNumbers = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int result = 0;
        for (int i = 1; i < numbers.length - 1; i++) {
            int leftWall = 0;
            int rightWall = 0;

            for (int j = 0; j < i; j++) {
                leftWall = Integer.max(numbers[j], leftWall);
            }

            for (int j = i + 1; j < w; j++) {
                rightWall = Integer.max(numbers[j], rightWall);
            }

            if (numbers[i] < leftWall && numbers[i] < rightWall) {
                result += Integer.min(leftWall, rightWall) - numbers[i];
            }
        }

        System.out.println(result);
    }
}