class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(answer[j] >= numbers[i] || numbers[i] <= numbers[j]) {
                    break;
                }
                
                if(answer[j] == -1 && numbers[i] > numbers[j]) {
                    answer[j] = numbers[i];
                }
            }
        }
        
        return answer;
    }
}