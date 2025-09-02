import java.util.*;

class Solution {
    
    int count = 0;
    int answer = 0;
    boolean[] visit;
    
    public int solution(int n, int[][] results) {
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int[] result : results) {
            List<Integer> winList = win.get(result[0]);
            List<Integer> loseList = lose.get(result[1]);
            
            winList.add(result[1]);
            loseList.add(result[0]);
        }
        
        for(int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            count = 0;
            
            dfs(win, i);
            dfs(lose, i);
            
            if(count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }

    public void dfs(List<List<Integer>> list, int index) {
        
        List<Integer> value = list.get(index);
        for(int element : value) {
            if(visit[element]) {
                continue;
            }
            
            visit[element] = true;
            count++;
            dfs(list, element);
        }
    } 
}