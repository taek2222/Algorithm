import java.util.*;

class Solution {
    
    static boolean[][] lineChecks;
    static int[] directionX = new int[]{0, 0, 1, -1};
    static int[] directionY = new int[]{1, -1, 0, 0};
    
    static int[] diagonalX = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
    static int[] diagonalY = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
    
    class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        lineChecks = new boolean[102][102];
        
        for(int[] rectangle : rectangles) {
            for(int i = rectangle[0] * 2; i <= rectangle[2] * 2; i++) {
                for(int j = rectangle[1] * 2; j <= rectangle[3] * 2; j++) {
                    lineChecks[i][j] = true;
                }
            }
        }
        
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(characterX * 2, characterY * 2, 0));
        
        boolean[][] visit = new boolean[102][102];
        visit[characterX * 2][characterY * 2] = true;
        
        while(!deque.isEmpty()) {
            Node current = deque.pop();
            
            if(current.x == itemX * 2 && current.y == itemY * 2) {
                return current.count / 2;
            }
            
            for(int i = 0; i < directionX.length; i++) {
                int nextX = current.x + directionX[i];
                int nextY = current.y + directionY[i];
                if(!lineChecks[nextX][nextY] || visit[nextX][nextY]) {
                    continue;
                }
                
                if(isMovePossible(nextX, nextY)) {
                    visit[nextX][nextY] = true;
                    deque.add(new Node(nextX, nextY, current.count + 1));
                }
            }
        }

        return 0;
    }
    
    private boolean isMovePossible(int x, int y) {
        for(int i = 0; i < diagonalX.length; i++) {
            int nextX = x + diagonalX[i];
            int nextY = y + diagonalY[i];
            if(!lineChecks[nextX][nextY]) {
                return true;
            }
        }
        return false;
    }
}