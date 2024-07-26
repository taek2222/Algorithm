import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Main {

    static ArrayList<Integer>[] nodeArrays;
    static boolean[] visitNode;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nodeArrays = new ArrayList[n+1];

        for (int i = 1; i <= n; i++)
            nodeArrays[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            String[] st = br.readLine().split(" ");
            int parentNode = Integer.parseInt(st[0]);
            int childNode = Integer.parseInt(st[1]);
            int weight = Integer.parseInt(st[2]);

            nodeArrays[parentNode].add(childNode);
            nodeArrays[parentNode].add(weight);
            nodeArrays[childNode].add(parentNode);
            nodeArrays[childNode].add(weight);

        }

        for (int i = 1 ; i < n+1; i++) {
            visitNode = new boolean[n+1];
            DFS(i, 0, 0);
        }

        System.out.println(max);
    }

    private static void DFS(int i, int total, int weight) {
        total += weight;

        visitNode[i] = true;

        ArrayList<Integer> nodes = nodeArrays[i];

        for (int j = 0; j < nodes.size(); j += 2) {
            if(visitNode[nodes.get(j)]) {
                if(max < total)
                    max = total;

                continue;
            }


            DFS(nodes.get(j), total, nodes.get(j+1));
        }
    }
}