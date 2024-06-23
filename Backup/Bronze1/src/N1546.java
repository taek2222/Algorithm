import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int class_ = Integer.parseInt(br.readLine());
        StringTokenizer score = new StringTokenizer(br.readLine());
        int[] Score = new int[class_];
        double total = 0;

        double max = (Score[0] = Integer.parseInt(score.nextToken()));

        for(int i = 1; i < class_; i++) {
            Score[i] = Integer.parseInt(score.nextToken());
            if(max < Score[i])
                max = Score[i];
        }

        for(int i = 0; i < class_; i++)
            total += ((Score[i] / max) * 100.0);

        System.out.print(total/class_);
    }
}
