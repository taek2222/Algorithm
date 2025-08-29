import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, ((c1, c2) -> Integer.compare(c1[2], c2[2])));
        
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        int answer = 0;
        int count = 0;
        for(int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int value = cost[2];
            
            if(find(parents, u) == find(parents, v)) {
                continue;
            }
            
            union(parents, u, v);
            answer += value;
            count++;
            
            if(n - 1 == count) {
                break;
            }
        }
        
        return answer;
    }
    
    public int find(int[] parents, int x) {
        if(parents[x] == x) return x;
        return find(parents, parents[x]);
    }
    
    public void union(int[] parents, int a, int b) {
        int aParent = find(parents, a);
        int bParent = find(parents, b);
        
        if(aParent < bParent) {
            parents[aParent] = bParent;
            return;
        }
        
        parents[bParent] = aParent;
    }
}