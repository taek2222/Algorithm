import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> stack = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer list = new StringTokenizer(br.readLine());
            switch (list.nextToken()) {
                case "push" -> push(Integer.parseInt(list.nextToken()), stack);
                case "pop" -> pop(stack);
                case "size" -> size(stack);
                case "empty" -> empty(stack);
                case "front" -> front(stack);
                case "back" -> back(stack);
            }
        }
    }

    public static void push(int number, ArrayList<Integer> array) {
        array.add(number);
    }

    public static void pop(ArrayList<Integer> array) {
        if(array.size() == 0)
            System.out.println(-1);
        else {
            System.out.println(array.get(0));
            array.remove(0);
        }
    }

    public static void size(ArrayList<Integer> array) {
        System.out.println(array.size());
    }

    public static void empty(ArrayList<Integer> array) {
        if(array.size() == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
    public static void front(ArrayList<Integer> array) {
        if(array.size() == 0)
            System.out.println(-1);
        else
            System.out.println(array.get(0));
    }
    public static void back(ArrayList<Integer> array) {
        if(array.size() == 0)
            System.out.println(-1);
        else
            System.out.println(array.get(array.size()-1));
    }
}
