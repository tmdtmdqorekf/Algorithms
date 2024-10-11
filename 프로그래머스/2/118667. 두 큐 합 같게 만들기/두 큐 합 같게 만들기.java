import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // 두 큐의 합을 저장할 변수
        long sumQ1 = 0, sumQ2 = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        // 각 큐의 합 구하기
        for (int i = 0; i < queue1.length; i++) {
            q1.add((long) queue1[i]);
            sumQ1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add((long) queue2[i]);
            sumQ2 += queue2[i];
        }
        
        // 목표 값 계산
        long target = (sumQ1 + sumQ2) / 2;
        
        // 합이 홀수이면 불가능
        if ((sumQ1 + sumQ2) % 2 != 0) {
            return -1;
        }
        
        // 투 포인터처럼 두 큐에서 값을 옮기며 비교
        int limit = queue1.length * 3; // 최대 연산 횟수 제한 (한쪽 큐에서 모두 이동하는 최대 횟수)
        int count = 0;
        
        while (count < limit) {
            if (sumQ1 == target) {
                return answer;
            }
            
            // sumQ1이 더 작은 경우 q2에서 값을 꺼내 q1으로 이동
            if (sumQ1 < target) {
                long value = q2.poll();
                sumQ1 += value;
                sumQ2 -= value;
                q1.add(value);
            } 
            // sumQ1이 더 큰 경우 q1에서 값을 꺼내 q2로 이동
            else {
                long value = q1.poll();
                sumQ1 -= value;
                sumQ2 += value;
                q2.add(value);
            }
            answer++;
            count++;
        }
        
        return -1; // 불가능한 경우
    }
}
