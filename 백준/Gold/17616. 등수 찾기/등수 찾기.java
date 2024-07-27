import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");
        int N = Integer.parseInt(NMX[0]);
        int M = Integer.parseInt(NMX[1]);
        int X = Integer.parseInt(NMX[2]);

        ArrayList<Integer>[] list = new ArrayList[N+1];
        ArrayList<Integer>[] reversList = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            reversList[i] = new ArrayList<>();

        }

        for (int i = 0; i < M; i++) {
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);

            list[A].add(B);
            reversList[B].add(A);
        }

        visit = new boolean[N+1];
        count = 0;

        DFS(X, list);
        int V = N - count + 1;

        visit = new boolean[N+1];
        count = 0;

        DFS(X, reversList);
        int U = count;

        System.out.println(U + " " + V);
    }

    private static void DFS(int x, ArrayList<Integer>[] list) {
        ArrayList<Integer> arrayList = list[x];
        visit[x] = true;
        count++;

        for (int i : arrayList) {
            if(visit[i])
                continue;
            DFS(i, list);
        }
    }
}