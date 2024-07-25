import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    static ArrayList<Integer>[] nodeArray;
    static HashSet<Integer> visitNode = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        nodeArray = new ArrayList[N+1];

        for(int i = 0; i <= N; i++)
            nodeArray[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            int num1 = Integer.parseInt(nodes[0]);
            int num2 = Integer.parseInt(nodes[1]);

            nodeArray[num1].add(num2);
            nodeArray[num2].add(num1);
        }

        for(int i = 1; i <= N; i++) {
            if(visitNode.contains(i)) {
               continue;
            }
            DFS(i);
            answer++;
        }
        System.out.println(answer);
    }

    private static void DFS(int node) {
        visitNode.add(node);
        ArrayList<Integer> nodes = nodeArray[node];

        for (int i : nodes) {
            if(visitNode.contains(i))
                continue;
            DFS(i);
        }
    }
}