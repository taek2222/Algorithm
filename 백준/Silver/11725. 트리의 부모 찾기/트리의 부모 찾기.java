import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] list; // 리스트 저장
    static boolean[] visitArray; // 방문 노드
    static int[] parentNode; // 부모 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visitArray = new boolean[N+1];
        parentNode = new int[N+1];

        for(int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < N-1 ; i++) {
            String[] st = br.readLine().split(" ");
            int num1 = Integer.parseInt(st[0]);
            int num2 = Integer.parseInt(st[1]);

            list[num1].add(num2);
            list[num2].add(num1);
        }

        DFS(1);

        for (int i = 2; i <= N; i++)
            System.out.println(parentNode[i]);
    }

    static public void DFS(int vertex) {
        visitArray[vertex] = true;
        ArrayList<Integer> check = list[vertex];

        for (int i : check) {
            if(visitArray[i])
                continue;

            parentNode[i] = vertex;

            DFS(i);
        }
    }
}