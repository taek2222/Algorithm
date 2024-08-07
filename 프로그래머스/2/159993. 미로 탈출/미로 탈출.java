import java.util.*;

class Solution {
    
    class Node {
        int x, y, distance;
        
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        } 
    }
    
    boolean[][] visit;
    char[][] graph;
    int maxX, maxY;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    
    public int solution(String[] maps) {
        maxX = maps.length;
        maxY = maps[0].length();
            
        graph = new char[maxX][maxY];
        Node S = null;
        
        for(int i = 0; i < maxX; i++)
            for(int j = 0; j < maxY; j++) {
                graph[i][j] = maps[i].charAt(j);
                if(graph[i][j] == 'S') {
                    S = new Node(i, j, 0);
                } 
            }
        
        // 레버 찾기
        Node L = BFS(S, 'L');
        if(L == null)
            return -1;
        System.out.println(L.distance);
        
        // 레버부터 도착지까지 최단 거리
        Node E = BFS(L, 'E');
        if(E == null)
            return -1;
        
        return E.distance;
    }
    
    public Node BFS(Node start, char ch) {
        
        visit = new boolean[maxX][maxY];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start.x][start.y] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(graph[node.x][node.y] == ch)
                return node;
            
            for(int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                
                if(nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && graph[nextX][nextY] != ('X') && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, node.distance + 1));
                }
            }
        }
        
        return null;
    }
}