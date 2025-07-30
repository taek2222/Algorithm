class Solution {
    public int solution(int[][] sizes) {
        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes) {
            if(maxW < size[0]) {
                maxW = size[0];
            }
            
            if(maxH < size[1]) {
                maxH = size[1];
            }
        }
        
        return maxW * maxH;
    }
}