import java.util.*;

class Solution {
    
    static Set<Set<String>> answer;
    static Set<String> set;
    
    public int solution(String[] users, String[] bannedIds) {
        
        answer = new HashSet<>();
        set = new HashSet<>();
        dfs(users, bannedIds, 0, 0);
        
        return answer.size();
    }
    
    public void dfs(String[] users, String[] bannedIds, int bannedPos, int passCount) {
        if(bannedIds.length == bannedPos) {
            if(bannedIds.length == passCount) {
                answer.add(new HashSet<>(set));
            }
            return;
        }
        
        for(int i = 0; i < users.length; i++) {
            if(!set.contains(users[i]) && check(users[i], bannedIds[bannedPos])) {
                set.add(users[i]);
                dfs(users, bannedIds, bannedPos + 1, passCount + 1);
                set.remove(users[i]);
            }
        }
    }
    
    public boolean check(String userName, String bannedName) {
        if(userName.length() != bannedName.length()) {
            return false;
        }
        
        for(int i = 0; i < userName.length(); i++) {
            char bannedNamePos = bannedName.charAt(i);
            char userNamePos = userName.charAt(i);
            if(bannedNamePos == '*') {
                continue;
            }
            
            if(userNamePos != bannedNamePos) {
                return false;
            }
        }
        
        return true;
    }
}