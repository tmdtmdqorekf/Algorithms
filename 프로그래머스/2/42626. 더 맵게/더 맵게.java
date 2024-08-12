import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int least = pq.poll();
            int second = pq.poll();

            int mixed = least + (second * 2);

            pq.add(mixed);
            answer++;
        }

        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}