import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Arrays.fill(answer, 0);
        
        HashMap<String, Integer> mailTotal = new HashMap<>();
        HashMap<String, ArrayList<String>> reportList = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++)
            mailTotal.put(id_list[i], i);
        
        for(String rp : report) {
            String[] rpArray = rp.split(" ");
            
            if(!reportList.containsKey(rpArray[1]))
                reportList.put(rpArray[1], new ArrayList<>());
            
            ArrayList<String> array = reportList.get(rpArray[1]);
            
            if(array.contains(rpArray[0]))
                continue;
            
            array.add(rpArray[0]);
            reportList.put(rpArray[1], array);
        }
        
        for(String id : id_list) {
            if(!reportList.containsKey(id))
                continue;
            
            ArrayList<String> array = reportList.get(id);
            if(array.size() < k)
                continue;
            
            for(String name : array)
                answer[mailTotal.get(name)]++;
        }
        
        return answer;
    }
}