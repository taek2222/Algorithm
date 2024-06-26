import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        // spell 정렬
        Arrays.sort(spell);
        
        System.out.println("spell : " + Arrays.toString(spell));
        
        for(String s : dic) {
            String[] dicDivision = s.split("");
            Arrays.sort(dicDivision);
            
            if((spell.length == dicDivision.length) && check(spell, dicDivision))
                return 1;
        }
        
        return 2;
    }
    
    // 값 체크
    public boolean check(String[] spell, String[] dicDivision) {
        for(int i = 0; i < spell.length; i++)
            if(!spell[i].equals(dicDivision[i]))
                return false;
        return true;
    }
}