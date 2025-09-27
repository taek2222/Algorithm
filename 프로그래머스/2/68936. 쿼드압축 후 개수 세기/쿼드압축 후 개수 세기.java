class Solution {
    
    int answer[];
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        dfs(0, 0, arr.length, arr[0].length, arr);
        
        return answer;
    }
    
    public void dfs(int startX, int startY, int endX, int endY, int[][] arr) {
        if(check(startX, startY, endX, endY, arr)) {
            count(arr[startX][startY]);
            return;
        }
        
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        
        dfs(startX, startY, midX, midY, arr);
        dfs(midX, startY, endX, midY, arr);
        dfs(startX, midY, midX, endY, arr);
        dfs(midX, midY, endX, endY, arr);
    }
    
    public boolean check(int startX, int startY, int endX, int endY, int[][] arr) {
        int startPos = arr[startX][startY];
        for(int i = startX; i < endX; i++) {
            for(int j = startY; j < endY; j++) {
                if(startPos != arr[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void count(int number) {
        if(number == 1) {
            answer[1]++;
            return;
        }
        
        answer[0]++;
    }
}