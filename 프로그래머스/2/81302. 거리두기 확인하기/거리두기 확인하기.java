import java.util.*;

class Solution {
    
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            String[][] place = buildPlace(places[i]);
            if(validateDistance(place)) {
                answer[i] = 1;
                continue;
            }
            answer[i] = 0;
        }
        
        return answer;
    }
    
    public boolean validateDistance(String[][] place) {
        for(int i = 0; i < place.length; i++) {
            for(int j = 0; j < place[0].length; j++) {
                if(!place[i][j].equals("P")) continue;
                if(checkDistance(place, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean checkDistance(String[][] place, int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visit = new boolean[place.length][place[0].length];
        
        deque.add(new int[]{x, y});
        visit[x][y] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.pop();
            
            for(int i = 0; i < dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= place.length || ny >= place[0].length) {
                    continue;
                }
                
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                if(visit[nx][ny] || place[nx][ny].equals("X") || distance > 2) {
                    continue;
                }
                visit[nx][ny] = true;
                
                if(place[nx][ny].equals("P")) {
                    return true;
                }
                
                deque.add(new int[]{nx, ny});
            }
        }
        
        return false;
    }
    
    public String[][] buildPlace(String[] places) {
        String[][] place = new String[5][5];
        for(int i = 0; i < place.length; i++) {
            String[] divide = places[i].split("");
            for(int j = 0; j < place[0].length; j++) {
                place[i][j] = divide[j];
            }
        }
        
        return place;
    }
}