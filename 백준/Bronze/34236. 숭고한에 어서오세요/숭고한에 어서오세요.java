import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] years = br.readLine().split(" ");
        int different = Math.abs(Integer.parseInt(years[0]) - Integer.parseInt(years[1]));

        System.out.println(different * years.length + Integer.parseInt(years[0]));
    }
}
