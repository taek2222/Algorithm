import java.util.*;

class Solution {
    
    static ArrayDeque<String> stack;
    
    private static void stackInit() {
        stack = new ArrayDeque<>();
    }
    
    private static void stackPush(String st) {
        stack.push(st);
    }
    
    private static boolean stackPop(String st) {
        if(stack.isEmpty())
            return false;
        
        String checkSt = stack.pop();
        switch(st) {
            case "]" : if(checkSt.equals("[")) return true; break;
            case "}" : if(checkSt.equals("{")) return true; break;
            case ")" : if(checkSt.equals("(")) return true; break;
        }
        return false;
    }
    
    private static boolean stackChack() {
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        String[] strArr = s.split("");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));
        
        for(int i = 0; i < s.length(); i++) {
            boolean flag = true;
            stackInit();
            for(int j = i; j < list.size(); j++) {
                String st = list.get(j);
                
                if(st.equals("[") || st.equals("{") || st.equals("("))
                    stackPush(st);
                else if (!stackPop(st)) {
                    flag = false;
                    break;
                }
            }
            
            if(stackChack() && flag)
                answer++;
            
            list.add(strArr[i]); // 마지막 추가
        }
        
        return answer;
    }
}