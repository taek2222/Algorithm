import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static class Load implements Comparable<Load> {
        int start;
        int end;
        int distance;

        public Load(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Load other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static int answer = Integer.MAX_VALUE;
    static ArrayList<Load> loads = new ArrayList<>();
    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end - start <= distance || end > D) continue;

            loads.add(new Load(start, end, distance));
        }

        Collections.sort(loads);

//        for (Load load : loads) {
//            System.out.println(load.start + " " + load.end + " " + load.distance);
//        }

        DFS(0, 0, 0);

        System.out.println(answer);
    }

    static void DFS(int pos, int loadStart, int totalDistance) {

        for (int i = pos; i < loads.size(); i++) {
            Load nowLoad = loads.get(i);

            if (loadStart > nowLoad.start)
                continue;

            int distance = (nowLoad.start - loadStart) + nowLoad.distance;

            DFS(i + 1, nowLoad.end, totalDistance + distance);
        }

        totalDistance = (D - loadStart) + totalDistance;
        answer = Integer.min(answer, totalDistance);
    }
}