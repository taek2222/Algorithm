class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String sub = s.substring(0, i);
            int count = 1;
            for(int j = i; j <= s.length(); j += i) {
                String next;
                if(j + i <= s.length()) {
                    next = s.substring(j, j + i);
                } else {
                    next = s.substring(j);
                }
                
                if(next.equals(sub)) {
                    count++;
                    continue;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(sub);
                    sub = next;
                    count = 1;
                }
            }
            if(count > 1) {
                sb.append(count);
            }
            sb.append(sub);
            
            answer = Math.min(answer, sb.length());
        }
        
        if(s.length() == 1) {
            return 1;
        }
        return answer;
    }
}

/**
1. 전체 길이의 반까지 시도
2. 반복문 하면서 넘어가고
3. 가장 작은 수 
**/
