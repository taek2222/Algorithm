import java.util.*;

class Solution {
    
    class Node {
        int pos;
        int weight;
        
        public Node(int pos, int weight) {
            this.pos = pos;
            this.weight = weight;
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> edges = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) edges.add(new ArrayList<>()); 
        for(int[] e : edge) {
            List<Integer> value = edges.get(e[0]);
            value.add(e[1]);
            
            value = edges.get(e[1]);
            value.add(e[0]);
        }
        
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1, 1));
        
        int answer = 0;
        int maxWeight = 0;
        while(!deque.isEmpty()) {
            Node current = deque.poll();
            
            if(maxWeight < current.weight) {
                answer = 0;
                maxWeight = current.weight;
            }
            
            if(maxWeight == current.weight) {
                answer++;
            }
            
            List<Integer> list = edges.get(current.pos);
            for(int element : list) {
                if(visit[element]) continue;
                visit[element] = true;
                deque.add(new Node(element, current.weight + 1));
            }
        }
        
        return answer;
    }
}

/**
    1. 번호 별로 노드 다 종합 (양쪽다)
    2. BFS로 탐색 (방문 노드 처리)
    3. 지금까지 최대인지 확인 (노드 객체 필요할듯)
    4. 현재 기준으로 더 먼 노드가 나온다? 다 초기화후 1부터 시작
**/