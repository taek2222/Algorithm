import java.util.*;

class Solution {
    Set<Integer> numbersSet = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);
        
        int count = 0;
        for (int num : numbersSet) {
            if (isPrime(num)) count++;
        }
        return count;
    }
    
    public void dfs(String current, String numbers, boolean[] visited) {
        if(!current.equals("")) {
            numbersSet.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}