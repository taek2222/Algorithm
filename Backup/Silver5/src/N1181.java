import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[Integer.parseInt(br.readLine())];

        for(int i = 0; i < str.length; i++)
            str[i] = br.readLine();

        for(int i = 0; i < (str.length -1) ; i++) {
            int check = 0;
            for(int j = i+1; j < (str.length); j++) {
                if(str[i].length() > str[j].length()){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                    check = 1;
                } else if(str[i].length() == str[j].length()) {
                    if(str[i].compareTo(str[j]) > 0) {
                        String temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                        check = 1;
                    }
                }
                if(str[i].equals(str[j])) {
                    check = 2;
                    break;
                }
            }
            if(check == 1)
                System.out.println(str[i]);
        }
        System.out.print(str[str.length-1]);
    }
}