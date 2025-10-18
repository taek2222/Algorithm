class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliveryPos = n - 1;
        int pickupPos = n - 1;
        
        while(deliveryPos >= 0 || pickupPos >= 0) {
            while (deliveryPos >= 0 && deliveries[deliveryPos] == 0) deliveryPos--;
            while (pickupPos >= 0 && pickups[pickupPos] == 0) pickupPos--;
            
            if (deliveryPos < 0 && pickupPos < 0) break;

            answer += (Math.max(deliveryPos, pickupPos) + 1) * 2L;

            int box = cap;
            
            while (deliveryPos >= 0 && box > 0) {
                if (deliveries[deliveryPos] <= box) {
                    box -= deliveries[deliveryPos];
                    deliveries[deliveryPos] = 0;
                    deliveryPos--;
                } else {
                    deliveries[deliveryPos] -= box;
                    box = 0;
                }
            }

            box = cap;
            
            while (pickupPos >= 0 && box > 0) {
                if (pickups[pickupPos] <= box) {
                    box -= pickups[pickupPos];
                    pickups[pickupPos] = 0;
                    pickupPos--;
                } else {
                    pickups[pickupPos] -= box;
                    box = 0;
                }
            }
        }
        
        return answer;
    }
}