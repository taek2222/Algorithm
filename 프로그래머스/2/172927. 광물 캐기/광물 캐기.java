import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    Map<String, Map<String, Integer>> pickFatigue = Map.of(
        "diamond", Map.of("diamond", 1, "iron", 1, "stone", 1),
        "iron", Map.of("diamond", 5, "iron", 1, "stone", 1),
        "stone", Map.of("diamond", 25, "iron", 5, "stone", 1)
    );
    
    public int solution(int[] picks, String[] minerals) {
        
        if(picks[0] != 0) dfs(picks[0] - 1, picks[1], picks[2], minerals, 0, 0, "diamond");
        if(picks[1] != 0) dfs(picks[0], picks[1] -1, picks[2], minerals, 0, 0, "iron");
        if(picks[2] != 0) dfs(picks[0], picks[1], picks[2] - 1, minerals, 0, 0, "stone");
        
        return answer;
    }
    
    private void dfs(int dia, int iron, int stone, String[] minerals, int mineralDepth, int fatigue, String currentPick) {
        // System.out.println("다이아 곡 : " + dia + " 철 곡 : " + iron + " 돌 곡 : " + stone);
        // System.out.println("동굴 깊이 : " + mineralDepth + " 피로도 : " + fatigue);
        // System.out.println("현재 곡갱이 : " + currentPick);

        int maxPick = Math.min(minerals.length, mineralDepth + 5);
        for(int i = mineralDepth; i < maxPick; i++) {
            String mineral = minerals[i];
            fatigue += pickFatigue.get(currentPick).get(mineral);
        }
        
                
        if(dia + iron + stone == 0 || mineralDepth > minerals.length) {
            answer = Math.min(answer, fatigue);
            return;
        }
        
        if(dia != 0) {
            dfs(dia - 1, iron, stone, minerals, mineralDepth + 5, fatigue, "diamond");
        }
        
        if(iron != 0) {
            dfs(dia, iron - 1, stone, minerals, mineralDepth + 5, fatigue, "iron");
        }
        
        if(stone != 0) {
            dfs(dia, iron, stone - 1, minerals, mineralDepth + 5, fatigue, "stone");
        }
    }
}