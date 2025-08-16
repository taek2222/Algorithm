import java.time.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<LocalTime> times = new ArrayList<>();
        
        for(String time: timetable) {
            times.add(LocalTime.parse(time));
        }
        Collections.sort(times);
        
        int crewIndex = 0;
        LocalTime busTime = LocalTime.of(9, 0);
        for(int i = 0; i < n - 1; i++) {
            int current = 0;
            while(true) {
                // 버스 탑승
                if(current < m && crewIndex < times.size() && !busTime.isBefore(times.get(crewIndex))) {
                    current++;
                    crewIndex++;
                    continue;
                } 
                break;
            }
            busTime = busTime.plusMinutes(t);
        }
        
        int maxCrewIndex = crewIndex;
        int current = 0;
        busTime = busTime.plusMinutes(t);
        while(true) {
            if(current < m && maxCrewIndex < times.size() && !busTime.isBefore(times.get(maxCrewIndex))) {
                maxCrewIndex++;
                current++;
                continue;
            }
            break;
        }
        
        System.out.println(crewIndex);
        System.out.println(maxCrewIndex);
        
        if(crewIndex == maxCrewIndex) {
            return busTime.minusMinutes(t).toString();
        }
        
        if(maxCrewIndex - crewIndex < m) {
            return busTime.minusMinutes(t).toString();
        }
        
        return times.get(maxCrewIndex - 1).minusMinutes(1).toString();
    }
}