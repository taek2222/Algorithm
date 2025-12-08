import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        List<String> list = new LinkedList<>(Arrays.asList(str));
        ListIterator<String> cursor = list.listIterator(list.size());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            switch (command) {
                case "L" -> {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    continue;
                }
                case "D" -> {
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    continue;
                }
                case "B" -> {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    continue;
                }
            }

            String x = command.split(" ")[1];
            cursor.add(x);
        }

        StringBuilder sb = new StringBuilder();
        for (String element : list) {
            sb.append(element);
        }

        System.out.println(sb);
    }
}
