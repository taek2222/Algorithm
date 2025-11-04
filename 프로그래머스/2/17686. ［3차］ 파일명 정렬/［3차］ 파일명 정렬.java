import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> fileDivides = new ArrayList<>();
        
        for(String file : files) {
            int headIndex = 0;
            while(!isNumber(file.charAt(headIndex))) {
                headIndex++;
            }

            int numberIndex = headIndex;
            while(numberIndex < file.length() && isNumber(file.charAt(numberIndex))) {
                numberIndex++;
            }
            
            String head = file.substring(0, headIndex);
            String number = file.substring(headIndex, numberIndex);
            String tail = file.substring(numberIndex, file.length());
            
            String[] array = new String[]{head, number, tail};
            fileDivides.add(array);
        }
        
        Collections.sort(fileDivides, (a1, a2) -> {
            int compare = a1[0].toUpperCase().compareTo(a2[0].toUpperCase());
            Integer a1Number = Integer.parseInt(a1[1]);
            Integer a2Number = Integer.parseInt(a2[1]);
            
            if(compare == 0) {
                return a1Number.compareTo(a2Number);
            }
            return compare;
        });
        
        String[] answer = new String[fileDivides.size()];
        for(int i = 0; i < answer.length; i++) {
            String[] divide = fileDivides.get(i);
            answer[i] = divide[0] + divide[1] + divide[2];
        }
        
        return answer;
    }
    
    public boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}