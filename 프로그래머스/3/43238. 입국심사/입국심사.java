import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = times[0];
        long right = times[times.length-1] * (long)n;
        
        // 모든 사람을 심사하는 데 걸리는 시간을 기준으로 함
        while (left <= right) {
            long mid = (left + right) / 2; // 7+60=67 -> 67/2=33
            
            long complete = 0;
            for (int i = 0; i < times.length; i++) {
                // 0 + (33/7) = 4
                // 4 + (33/10) = 7
                complete += mid / times[i];
            }
            
            // 해당 시간으로 모든 사람이 심사를 받을 수 없는 경우
            if (complete < n) {
                left = mid + 1;
            }
            // 해당 시간으로 모든 사람이 심사를 받을 수 있는 경우
            else {
                right = mid - 1;
                answer = mid;   
            }
        }
        
        return answer;
    }
}