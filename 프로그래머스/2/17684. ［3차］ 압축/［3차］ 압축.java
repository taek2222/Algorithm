import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> book = new HashMap<>();
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            book.put(String.valueOf(ch), ch - 64);
        }
        
        List<Integer> answers = new ArrayList<>();
        String[] array = msg.split("");
        for(int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(array[i]);
            
            while(true) {
                if(i + 1 >= array.length) break;
                sb.append(array[i + 1]);
                
                if(!book.containsKey(sb.toString())) {
                    sb.setLength(sb.length() - 1);
                    break;
                }
                
                i++;
            }
            
            answers.add(book.get(sb.toString()));
            
            if(i + 1 < array.length) {
                sb.append(array[i + 1]);
                book.put(sb.toString(), book.size() + 1);
            }
        }
        
        int[] answer = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}

/**
1. 연속적으로 사전에 있는 단어 탐색
2. 딱 그 전까지 있는 사전 등록
3. 새로운 사전 등록
**/