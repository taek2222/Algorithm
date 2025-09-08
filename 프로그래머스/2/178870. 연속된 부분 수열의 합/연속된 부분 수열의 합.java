class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        
        int[] answer = new int[]{0, sequence.length};
        
        int total = sequence[0];
        while(end < sequence.length) {
            if(total == k) {
                if(answer[1] - answer[0] > end - start) {
                    answer = new int[]{start, end};
                }
                end++;
                if(end >= sequence.length) {
                    break;
                }
                
                total += sequence[end];
            } else if(k > total) {
                end++;
                
                if(end >= sequence.length) {
                    break;
                }
                total += sequence[end];
            } else {
                total -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}