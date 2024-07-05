import java.util.*;

class Solution {
    private static boolean isVaildMove(int nx, int ny) {
        return nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10; 
    }
    
    private static HashMap<Character, int[]> moveArray = new HashMap<>();
    
    private static void initLocation() {
        moveArray.put('U', new int[] {0, 1});
        moveArray.put('D', new int[] {0, -1});
        moveArray.put('R', new int[] {1, 0});
        moveArray.put('L', new int[] {-1, 0});
    }
    
    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            int[] move = moveArray.get(dirs.charAt(i));
            int nx = x + move[0];
            int ny = y + move[1];
            
            if(!isVaildMove(nx, ny))
                continue;
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
        
        return answer.size() / 2;
    }
}