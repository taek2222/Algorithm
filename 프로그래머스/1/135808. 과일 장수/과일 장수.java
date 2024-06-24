import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int[] boxScore = new int[k+1]; // 한 박스의 최저 사과 점수 배열
        int answer = 0;
        
        // 1. score 점수 오름 차순 정렬
        Arrays.sort(score);
        
        // 2. 오름차순 배열 뒤에서 부터 반복문 시작 
        // 만약, 남은 사과가 한 상자에 담긴 사과 갯수 보다 적을 시 중단
        for(int i = score.length; i >= m; i-=m) {
            boxScore[packing(score, i-m, i-1, k)]++;
        }
        
        // 3. 박스의 최저 사과 점수 기반 최대 이익 계산
        for(int index = 1; k >= index; index++) {
            // 만약 index 카운트가 있을 시. ex) 한 박스의 최소 사과 점수가 3이면 index : 3
            if(boxScore[index] > 0)
                // (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수)
                answer += index * m * boxScore[index];
        }   
        return answer;
    }
    
    // 한 상자의 최저 사과 점수 찾기 (rmin, rmax : 범위, min : 최저 값 (기본 값 : 사과의 최대 점수 k))
    public int packing(int[] score, int rmin, int rmax, int min) {
        
        for(; rmin < rmax; rmin++)
            if(min > score[rmin])
                 min = score[rmin];
        
        return min;
    }
}