class Solution {
    
    static int[] chess;
    static int N;
    static int answer = 0;
    
    public int solution(int n) {
        chess = new int[n];
        N = n;
        
        backTracking(0);
        
        return answer;
    }
    
    private void backTracking(int depth) {
        if(depth == N) {
            answer++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            chess[depth] = i;
            if(check(depth))
                backTracking(depth+1);
        }
    }
    
    private boolean check(int depth) {
        for(int i = 0; i < depth; i++) {
            if(chess[i] == chess[depth])
                return false;
            
            if(Math.abs(depth - i) == Math.abs(chess[depth] - chess[i]))
                return false;
        }
        return true;
    }
}