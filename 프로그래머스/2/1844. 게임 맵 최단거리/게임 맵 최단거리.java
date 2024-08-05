import java.util.*;

class Node {
    int x, y, distance;
    
    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Solution {
    
    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        m = maps.length;
        n = maps[0].length;
        boolean[][] visit = new boolean[m][n];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visit[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.x == m-1 && node.y == n-1)
                return node.distance;
            
            for(int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visit[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, node.distance + 1));
                }
            }
        }
        
        return -1;
    }
}