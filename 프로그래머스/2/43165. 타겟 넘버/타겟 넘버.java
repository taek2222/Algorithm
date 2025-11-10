class Solution {
    
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return answer;
    }
    
    public void dfs(int depth, int[] numbers, int current, int target) {
        if(depth == numbers.length) {
            if(current == target) {
                answer++;
            }
            return;
        }
        
        int num = numbers[depth];
        dfs(depth + 1, numbers, current + num, target);
        dfs(depth + 1, numbers, current - num, target);
    }
}

/**
1. DFS, 방문 처리는 할 필요 없음
2. 깊이에 따라 마지막 체크
**/