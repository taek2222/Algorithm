class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int num;
            if(storey % 10 > 5 || ((storey % 10 == 5 && ((storey / 10) % 10) >= 5))) {
                num = 10 - storey % 10;
                storey = storey / 10 + 1;
            } else {
                num = storey % 10;
                storey = storey / 10;
            }
            
            answer += num;
        }
        
        return answer;
    }
}