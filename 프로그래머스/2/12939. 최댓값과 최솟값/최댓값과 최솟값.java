class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] numbers = s.split(" ");
        for(int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            
            if(max < num) {
                max = num;
            }
            
            if(min > num) {
                min = num;
            }
        }
        
        return "" + min + " " + max;
    }
}