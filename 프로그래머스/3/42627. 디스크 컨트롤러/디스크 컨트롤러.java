import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> {
            return Integer.compare(j1[0], j2[0]);
        });
        
        PriorityQueue<int[]> deque = new PriorityQueue<>((t1, t2) -> {
            if(t1[1] != t2[1]) {
                return Integer.compare(t1[1], t2[1]);
            }
            return 0;
        });
        
        int time = jobs[0][0];
        int queueIndex = 0;
        
        for(int[] job : jobs) {
            if(time != job[0]) break;
            deque.add(job);
            queueIndex++;
        }
        
        List<Integer> answers = new ArrayList<>();
        while(!deque.isEmpty()) {
            int[] process = deque.poll();
            time += process[1];
            
            answers.add(time - process[0]);
            
            for(; queueIndex < jobs.length; queueIndex++) {
                if(jobs[queueIndex][0] > time) break;
                deque.add(jobs[queueIndex]);
            }
            
            if(deque.isEmpty() && queueIndex < jobs.length) {
                time = jobs[queueIndex][0];
                deque.add(jobs[queueIndex++]);
            }
        }
        
        int answer = 0;
        for(int element : answers) {
            answer += element;
        }
        return answer / jobs.length;
    }
}
/**
    우선 순위 큐 사용
    1. 우선 시간 순서로 정렬
    2. 큐 첫번째 삽입하고
    3. 꺼내서 마감 시간 확인
    4. 마감 시간과 같거나 그 아래인 항목 저장
    5. 처리한 시간은 기록 현재 시간 - 시작 시간'
    작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 
**/