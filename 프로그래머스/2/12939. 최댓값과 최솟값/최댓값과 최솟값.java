class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int first = Integer.parseInt(numbers[0]);
        int max = first;
        int min = first;
        
        for(int i = 1; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return "" + min + " " + max;
    }
}