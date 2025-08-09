class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int endTime = getEndTime(schedules[i]);
            int[] timelog = timelogs[i];
            int day = startday;
            
            int count = 0;
            for(int log : timelog) {
                if(isHoliday(day)) {
                    day++;
                    continue;
                }
                
                if(log <= endTime) {
                    count++;
                }
                
                day++;
            }
            
            if(count == 5) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isHoliday(int day) {
        return day == 7 || (day % 7) == 6;
    }
    
    public int getEndTime(int time) {
        int endTime = time + 10;
        
        if (endTime % 100 > 59) {
            return time + 50;
        }
        return endTime;
    }
}