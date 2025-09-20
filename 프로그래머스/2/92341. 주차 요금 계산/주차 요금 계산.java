import java.util.*;
import java.time.*;

class Solution {
    
    private int baseTime;
    private int baseFee;
    private int unitTime;
    private int unitFee;
    
    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
    
        Map<String, LocalTime> parkings = new HashMap<>();
        Map<String, Integer> duration = new HashMap<>();
        Map<String, Integer> feeRecord = new HashMap<>();
    
        for(String record : records) {
            String[] recordSplit = record.split(" ");
            LocalTime time = LocalTime.parse(recordSplit[0]);
            String carNumber = recordSplit[1];
            String status = recordSplit[2];
            
            if(status.equals("IN")) {
                parkings.put(carNumber, time);
                continue;
            }
            
            LocalTime startTime = parkings.get(carNumber);
            int different = (int) Duration.between(startTime, time).toMinutes();
            parkings.remove(carNumber);
            duration.put(carNumber, duration.getOrDefault(carNumber, 0) + different);
        }
    
        for(String carNumber : parkings.keySet()) {
            LocalTime startTime = parkings.get(carNumber);
            int different = (int) Duration.between(startTime, LocalTime.of(23, 59)).toMinutes();
            duration.put(carNumber, duration.getOrDefault(carNumber, 0) + different);
        }
        
        for(String carNumber : duration.keySet()) {
            int different = duration.get(carNumber);
            int fee = calculateFee(different);
            feeRecord.put(carNumber, fee);
        }
        
        int[] answer = new int[feeRecord.size()];
    
        List<String> list = new ArrayList<>(feeRecord.keySet());
        Collections.sort(list);
    
        for(int i = 0; i < list.size(); i++) {
            answer[i] = feeRecord.get(list.get(i));
        }
    
        return answer;
    }

    private int calculateFee(int different) {
        if(different <= baseTime) {
            return baseFee;
        }
        
        int value = (int) Math.ceil((double)(different - baseTime) / unitTime);
        
        return value * unitFee + baseFee;
    }
}