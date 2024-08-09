import java.util.*;

class Solution {
    
    private class Node {
        int dest, cost;
        
        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<Node>[] array = new ArrayList[N+1];
        
        for(int i = 0; i <= N; i++)
            array[i] = new ArrayList<>();
        
        for(int[] ro : road) {
            array[ro[0]].add(new Node(ro[1], ro[2]));
            array[ro[1]].add(new Node(ro[0], ro[2]));
        }
        
        int[] visit = new int[N+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(1, 0));
        visit[1] = 0;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(visit[now.dest] < now.cost)
                continue;
            
            for(Node next : array[now.dest]) {
                if(visit[next.dest] > now.cost + next.cost) {
                    visit[next.dest] = now.cost + next.cost;
                    queue.add(new Node(next.dest, visit[next.dest]));
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++)
            if(visit[i] <= K)
                answer++;
    
        return answer;
    }
}