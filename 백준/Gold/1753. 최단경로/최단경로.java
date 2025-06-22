import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        Map<Integer, Map<Integer, Integer>> roads = new HashMap<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> value = roads.getOrDefault(u, new HashMap<>());
            int weight = w;
            if (value.containsKey(v)) {
                int currentWeight = value.get(v);
                if (currentWeight < w) {
                    weight = currentWeight;
                }
            }
            value.put(v, weight);

            roads.put(u, value);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 1 : 갈 위치, 2 : 가중치 합
        int[] answer = new int[V + 1];
        boolean[] visit = new boolean[V + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[K] = 0;

        queue.add(new int[]{K, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            Map<Integer, Integer> value = roads.getOrDefault(node[0], Map.of());
            for (Entry<Integer, Integer> entry : value.entrySet()) {
                int endPos = entry.getKey();
                int weight = entry.getValue();

                if (!visit[endPos] && answer[endPos] > weight + node[1]) {
                    visit[node[0]] = true;
                    answer[endPos] = weight + node[1];
                    queue.add(new int[]{endPos, answer[endPos]});
                }
            }
        }

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(answer[i]);
        }
    }
}
