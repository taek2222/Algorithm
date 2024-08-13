import java.util.*;

class Solution {
    
    class Node {
        int vertex, distance;
        
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] cost = new int[n+1];
    
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        
        // 간선 연결
        for(int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        // BFS 알고리즘 사용
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = cost[1] = 0;
        queue.add(new Node(1, 0));
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            // System.out.println("간선 : " + now.vertex + " 가중치 : " + now.distance);
            
            for(int vertex : list[now.vertex]) {
                if(cost[vertex] <= now.distance + 1)
                    continue;
                
                cost[vertex] = now.distance + 1;
                queue.add(new Node(vertex, now.distance + 1));
            }
        }
        
        int max = 0;
        for(int i = 1; i < cost.length; i++)
            max = Math.max(cost[i], max);
        
        int count = 0;
        for(int i = 1; i < cost.length; i++)
            if(cost[i] == max) count++;
        
        return count;
    }
}