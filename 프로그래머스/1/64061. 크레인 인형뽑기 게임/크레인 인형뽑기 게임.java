import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
            int moveY = moves[i] - 1; // 크레인 Y 축           
            int value = 0, doll = 0;
            
            for(int moveX = 0; moveX < board.length; moveX++) {
                doll = board[moveX][moveY];
                
                if(!(doll == 0)) {
                    value = doll;
                    board[moveX][moveY] = 0;
                    break;
                }
            }
            
            if(doll == 0)
                continue;
            
            if(!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                answer += 2;
            } else
                stack.push(doll);
        }
        
        
        return answer;
    }
}