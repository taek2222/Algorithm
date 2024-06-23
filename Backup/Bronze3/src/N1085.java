import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int xm, ym;
        int x = Integer.parseInt(str.nextToken());
        int y = Integer.parseInt(str.nextToken());
        int w = Integer.parseInt(str.nextToken());
        int h = Integer.parseInt(str.nextToken());

        if((w-x) > w / 2)
            xm = x;
        else
            xm = w - x;

        if((h-y) > h / 2)
            ym = y;
        else
            ym = h - y;

        System.out.print(Math.min(xm, ym));

    }
}
