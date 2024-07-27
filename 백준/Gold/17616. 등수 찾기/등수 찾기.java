import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static boolean[] visit;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");
        int N = Integer.parseInt(NMX[0]);
        int M = Integer.parseInt(NMX[1]);
        int X = Integer.parseInt(NMX[2]);

        visit = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);

            list[A].add(B);
        }

        DFS(X);

        int max = 1, min = 1;
        for(int i = 1; i < visit.length; i++) {
            if (visit[i])
                continue;

            min++;
            for(int j = 0; j < list[i].size(); j++) {
                if(list[i].get(j) == X)
                    max++;
            }
        }

        System.out.println(max + " " + min);
    }

    private static void DFS(int x) {
        ArrayList<Integer> arrayList = list[x];
        visit[x] = true;

        for (int i : arrayList) {
            if(visit[i])
                continue;
            DFS(i);
        }
    }
}