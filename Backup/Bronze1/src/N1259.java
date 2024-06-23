import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] array = br.readLine().split("");

            if(array[0].equals("0"))
                System.exit(0);

            int check = 0;

            for(int i = 0, j = (array.length - 1); i <= j; i++, j--)
                if(!(array[i].equals(array[j])))
                    check++;

            if(check > 0)
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}
