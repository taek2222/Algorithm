import java.util.*;

class Solution {
    
    static HashMap<String, String> fraud = new HashMap<>();
    static HashMap<String, Integer> moneyTotal = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < enroll.length; i++) {
            fraud.put(enroll[i], referral[i]);
            moneyTotal.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++)
            logic(seller[i], amount[i] * 100);
        
        for(String name : enroll)
            answer.add(moneyTotal.get(name));
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public void logic(String name, int gold) {
        if(name.equals("-"))
            return;
        
        int money = (int)(gold * 0.1);
        if(money < 1) {
            moneyTotal.put(name, moneyTotal.get(name) + gold);
            return;
        }
        
        int saveMoney = gold - money;
        moneyTotal.put(name, moneyTotal.get(name) + saveMoney);
        logic(fraud.get(name), money);
    }
}