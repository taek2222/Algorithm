import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static class TrafficLog {
        LocalDateTime start;
        LocalDateTime end;

        public TrafficLog(String log) {
            String[] parts = log.split(" ");
            String dateTimePart = parts[0] + " " + parts[1];
            String processTimePart = parts[2].replace("s", "");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            
            this.end = LocalDateTime.parse(dateTimePart, formatter);

            long processMillis = (long) (Double.parseDouble(processTimePart) * 1000);

            this.start = this.end.minus(Duration.ofMillis(processMillis - 1));
        }
    }

    public int solution(String[] lines) {
        List<TrafficLog> logs = new ArrayList<>();
        for (String line : lines) {
            logs.add(new TrafficLog(line));
        }

        int maxTraffic = 0;
        
        for (int i = 0; i < logs.size(); i++) {
            LocalDateTime startTime = logs.get(i).start;
            LocalDateTime endTime = logs.get(i).end;
            
            int traffic1 = countTraffic(logs, startTime, startTime.plus(Duration.ofMillis(999)));
            maxTraffic = Math.max(maxTraffic, traffic1);
            
            int traffic2 = countTraffic(logs, endTime, endTime.plus(Duration.ofMillis(999)));
            maxTraffic = Math.max(maxTraffic, traffic2);
        }
        
        return maxTraffic;
    }

    private int countTraffic(List<TrafficLog> logs, LocalDateTime windowStart, LocalDateTime windowEnd) {
        int count = 0;
        for (TrafficLog log : logs) {
            if (!log.start.isAfter(windowEnd) && !log.end.isBefore(windowStart)) {
                count++;
            }
        }
        return count;
    }
}