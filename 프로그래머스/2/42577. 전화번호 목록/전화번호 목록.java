import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_books) {
        boolean answer = true;
        Arrays.sort(phone_books);
        
        Set<String> phoneBooks = new HashSet<>();
        for(String phone : phone_books) {
            for(int i = 1; i < phone.length(); i++) {
                String sub = phone.substring(0, i);
                if(phoneBooks.contains(sub)) {
                    answer = false;
                    break;
                }
            }
            
            if(!answer) {
                break;
            } else {
                phoneBooks.add(phone);
            }
        }
        
        
        return answer;
    }
}