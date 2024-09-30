import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();
        
        // 대기 트럭 초기화
        for (int x : truck_weights) {
            q.add(x);
        }
        
        // 다리 bridge_length 만큼 초기화
        for (int i = 0; i < bridge_length; i++) {
            b.add(0);
        }
    
        // 메인 로직
        int w = 0;
        while (!b.isEmpty()) {
            time++;
            w -= b.poll();
            
            if (!q.isEmpty()) {
                // 무게를 초과하지 않는 경우
                if (w + q.peek() <= weight) {
                    int truck = q.poll();
                    b.add(truck);
                    w += truck;
                } else {
                    b.add(0);
                }
            }
        }
        
        return time;
    }
}