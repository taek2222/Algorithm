import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Integer, Integer> word = new HashMap<>();
        for(int i = 65; i <= 90; i++) {
            word.put(i, i);
        }
        
        for(int i = 1; i < skill.length(); i++) {
            word.put((int) skill.charAt(i), (int) skill.charAt(i - 1));
        }
        
        for(String skillTree : skill_trees) {
            boolean[] check = new boolean[26];
            boolean complete = true;
            for(int i = 0; i < skillTree.length(); i++) {
                int element = (int) skillTree.charAt(i);
                check[element - 65] = true;
                
                if(!check[word.get(element) - 65]) {
                    complete = false;
                    break;
                }
            }
            
            if(complete) {
                answer++;
            }
        }
        
        
        return answer;
    }
}