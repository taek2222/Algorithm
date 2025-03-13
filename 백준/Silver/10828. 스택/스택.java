import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> stack = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer list = new StringTokenizer(br.readLine());
            switch (list.nextToken()) {
                case "push": push(Integer.parseInt(list.nextToken()), stack); break;
                case "pop": pop(stack); break;
                case "size": size(stack); break;
                case "empty": empty(stack); break;
                case "top": top(stack); break;
            }
        }
    }

    public static void push(int number, ArrayList array) {
        array.add(number);
    }

    public static void pop(ArrayList array) {
        if(array.size() == 0)
            System.out.println(-1);
        else {
            System.out.println(array.get(array.size() - 1));
            array.remove(array.size() - 1);
        }
    }

    public static void size(ArrayList array) {
        System.out.println(array.size());
    }

    public static void empty(ArrayList array) {
        if(array.size() == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void top(ArrayList array) {
        if(array.size() == 0)
            System.out.println(-1);
        else
            System.out.println(array.get(array.size()-1));
    }
}
