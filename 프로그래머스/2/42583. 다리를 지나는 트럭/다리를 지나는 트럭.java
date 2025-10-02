import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentTruckWeight = 0;

        Queue<int[]> deque = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; ) {
            time++;

            if (!deque.isEmpty() && deque.peek()[1] == time) {
                currentTruckWeight -= deque.poll()[0];
            }

            if (currentTruckWeight + truck_weights[i] <= weight) {
                currentTruckWeight += truck_weights[i];
                deque.add(new int[]{truck_weights[i], time + bridge_length});
                i++;
            }
        }


        while (!deque.isEmpty()) {
            time = deque.poll()[1];
        }

        return time;
    }
}