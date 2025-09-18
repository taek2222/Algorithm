class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int arrayAGcd = arrayA[0];
        int arrayBGcd = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            arrayAGcd = gcd(arrayA[i], arrayAGcd);
        }
        
        for(int i = 1; i < arrayB.length; i++) {
            arrayBGcd = gcd(arrayB[i], arrayBGcd);
        }
        
        if(isDivision(arrayA, arrayBGcd)) {
            answer = Math.max(answer, arrayBGcd);
        }
        
        if(isDivision(arrayB, arrayAGcd)) {
            answer = Math.max(answer, arrayAGcd);
        }
        
        return answer;
    }
    
    public boolean isDivision(int[] array, int division) {
        for(int element : array) {
            if(element % division == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int gcd(int a, int b) {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}