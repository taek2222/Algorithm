import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> fileZip = new ArrayList<>();
        
        for(String file : files) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            
            int i = 0;
            for(; i < file.length(); i++) {
                char c = file.charAt(i);
                if(c >= '0' && c <= '9') {
                    break;
                }
                
                head.append(String.valueOf(c));
            }
            
            for(; i < file.length(); i++) {
                char c = file.charAt(i);
                if(c < '0' || c > '9' || number.length() == 5) {
                    break;
                }
                
                number.append(String.valueOf(c));
            }
            
            String tail = file.substring(i, file.length());
            
            fileZip.add(new String[]{head.toString(), number.toString(), tail});
        }
        
        Collections.sort(fileZip, ((s1, s2) -> {
            if(s1[0].toUpperCase().compareTo(s2[0].toUpperCase()) == 0) {
                return Integer.compare(Integer.parseInt(s1[1]), Integer.parseInt(s2[1]));
            }
            return s1[0].toUpperCase().compareTo(s2[0].toUpperCase());
        }));
        
        String[] answer = new String[fileZip.size()];
        for(int i = 0; i < fileZip.size(); i++) {
            String[] element = fileZip.get(i);
            
            StringBuilder sb = new StringBuilder();
            sb.append(element[0]);
            sb.append(element[1]);
            sb.append(element[2]);
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}