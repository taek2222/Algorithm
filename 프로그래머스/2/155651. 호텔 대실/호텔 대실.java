import java.util.*;
import java.time.*;

class Solution {
    
    class Time {
        private LocalTime start;
        private LocalTime end;
        
        Time(String start, String end) {
            this.start = LocalTime.parse(start);
            this.end = LocalTime.parse(end);
        }
        
        public String toString() {
            return start + " : " + end;
        }
    }
    
    public int solution(String[][] book_times) {
        List<Time> times = new ArrayList<>();
        
        for(String[] book_time : book_times) {
            times.add(new Time(book_time[0], book_time[1]));
        }
        
        times.sort((t1, t2) -> t1.start.compareTo(t2.start));
        
        PriorityQueue<Time> queue = new PriorityQueue<>((t1, t2) -> t1.end.compareTo(t2.end));
        
        int roomCount = 0;
        for(Time time : times) {
            
            if(queue.isEmpty()) {
                roomCount++;
                queue.add(time);
                continue;
            }
            
            if(!queue.peek().end.plusMinutes(10).isAfter(time.start)) {
                queue.poll();
                queue.add(time);
            } else {
                roomCount++;
                queue.add(time);
                continue;
            }
        }
        
        return roomCount;
    }
}