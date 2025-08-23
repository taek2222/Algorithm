class Solution {
    public int[] solution(int count) {
        int n = count;
        
        int[][] directions = new int[][] {
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, -1}
        };
        
        int number = 1;
        int[][] snail = new int[n][n];
        
        int directionPos = 0;
        int[] direction = directions[directionPos];
        int xPos = 0;
        int yPos = 0;
        
        while(n > 0) {
            snail[yPos][xPos] = number;
            number++;
            
            for(int i = 0; i < n - 1; i++) {
                xPos += direction[0];
                yPos += direction[1];
                
                snail[yPos][xPos] = number;
                number++;
            }
            
            n--;
            
            if(directionPos == 2) {
                directionPos = -1;
            }
            direction = directions[++directionPos];

            xPos += direction[0];
            yPos += direction[1];
        }
        
        int index = 0;
        int[] answer = new int[sequence(count)];
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < count; j++) {
                if(snail[i][j] == 0) {
                    continue;
                }
                answer[index] = snail[i][j];
                index++;
            }
        } 
        
        return answer;
    }
    
    private int sequence(int number) {
        int total = 0;
        for(int i = 0; i <= number; i++) {
            total += i;
        }
        
        return total;
    }
}