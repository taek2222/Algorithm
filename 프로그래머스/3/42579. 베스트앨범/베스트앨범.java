import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> totalPlays = new HashMap<>();
        HashMap<String, Integer[][]> numberPlays = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            if(!totalPlays.containsKey(genres[i])) {
                Integer[][] numbers = new Integer[3][2];
                numbers[0][0] = plays[i];
                numbers[0][1] = i;
                numbers[1][0] = numbers[1][1] = numbers[2][0] = numbers[2][1] = -1;
                
                numberPlays.put(genres[i], numbers);
                
                totalPlays.put(genres[i], plays[i]);
                continue;
            }
            int total = totalPlays.get(genres[i]) + plays[i];
            totalPlays.put(genres[i], total);
            
            Integer[][] num = numberPlays.get(genres[i]);
            if(num[0][0] < plays[i]) {
                num[1][0] = num[0][0];
                num[1][1] = num[0][1];
                num[0][0] = plays[i];
                num[0][1] = i;
            }  else if(num[1][0] < plays[i]) {
                num[1][0] = plays[i];
                num[1][1] = i;
            }
        }
        
        List<Map.Entry<String, Integer>> list = new LinkedList<>(totalPlays.entrySet());
        list.sort(((o1, o2) -> totalPlays.get(o2.getKey()) - totalPlays.get(o1.getKey())));
        
        for(Map.Entry<String, Integer> entry : list) {
            Integer[][] num = numberPlays.get(entry.getKey());
            int i = 0;
            while(!(num[i][1] == -1)) {
                answer.add(num[i][1]);
                i++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}