import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) parent[rb] = ra;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] truth = new int[t];
        for (int i = 0; i < t; i++) truth[i] = Integer.parseInt(st.nextToken());

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) arr[j] = Integer.parseInt(st.nextToken());
            parties[i] = arr;
            if (k >= 2) {
                int first = arr[0];
                for (int j = 1; j < k; j++) union(first, arr[j]);
            }
        }

        if (t == 0) {
            System.out.println(m);
            return;
        }

        for (int i = 1; i < t; i++) union(truth[0], truth[i]);
        int truthRoot = find(truth[0]);

        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int p : parties[i]) {
                if (find(p) == truthRoot) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ans++;
        }

        System.out.println(ans);
    }
}