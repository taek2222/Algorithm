import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class N4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bl = new StringBuilder();

        String[] str = br.readLine().split("");
        while(!(str[0].equals("."))) {
            Stack<String> save = new Stack<>();
            int i = 0;
            while (true) {
                if(str[i].equals("(") || str[i].equals("["))
                    save.push(str[i]);

                if(str[i].equals(")")) {
                    if (save.empty() || !Objects.equals(save.peek(), "(")) {
                        bl.append("no\n");
                        break;
                    }
                    else
                        save.pop();
                }

                if(str[i].equals("]")) {
                    if (save.empty() || !Objects.equals(save.peek(), "[")) {
                        bl.append("no\n");
                        break;
                    }
                    else
                        save.pop();
                }

                if(str[i].equals("."))
                    if(save.empty()) {
                        bl.append("yes\n");
                        break;
                    }
                    else {
                        bl.append("no\n");
                        break;
                    }

                i++;
            }
            str = br.readLine().split("");
        }
        System.out.println(bl);
    }
}
