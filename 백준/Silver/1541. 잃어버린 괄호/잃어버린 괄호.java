import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static String line;
    static int i;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();

        int total = 0;
        for (i = 0; i < line.length(); ) {
            char c = line.charAt(i); // 문자 추출

            if (c == '-') {
                i++; // 다음 문자
                int minusTotal = 0;
                for (; i < line.length(); i++) {
                    if (line.charAt(i) == '-') {
                        break;
                    }
                    minusTotal += extractNumber();
                }
                total -= minusTotal;
                continue;
            }
            if (c == '+') {
                i++;
            }

            total += extractNumber();
        }
        System.out.println(total);
    }

    private static int extractNumber() {
        StringBuilder number = new StringBuilder();
        while (!(line.charAt(i) == '+') && !(line.charAt(i) == '-')) {
            number.append(line.charAt(i));
            i++;

            if (line.length() <= i) {
                break;
            }
        }
        return Integer.parseInt(String.valueOf(number));
    }
}
