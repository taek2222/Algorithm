import java.util.*;

class Solution {
    
    Map<String, List<Integer>> infos;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        infos = new HashMap<>();
        
        for(String element : info) {
            String[] words = element.split(" ");
            dfs(words, new StringBuilder(), 0);
        }
        
        for (List<Integer> list : infos.values()) {
            Collections.sort(list);
        }
        
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = infos.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        
        return answer;
    }
    
    public int binarySearch(String key, int score) {
        List<Integer> scores = infos.get(key);
        int start = 0, end = scores.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return scores.size() - start;
    }
    
    public void dfs(String[] words, StringBuilder sb, int depth) {
        if(depth == 4) {
            List<Integer> value = infos.getOrDefault(sb.toString(), new ArrayList<>());
            value.add(Integer.parseInt(words[4]));
            infos.put(sb.toString(), value);
            return;
        }
        
        sb.append("-");
        dfs(words, sb, depth + 1);
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(words[depth]);
        dfs(words, sb, depth + 1);
        sb.delete(sb.length() - words[depth].length(), sb.length());
    }
}