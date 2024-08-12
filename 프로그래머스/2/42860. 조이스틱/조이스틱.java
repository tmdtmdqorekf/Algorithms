import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;

        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            // [상하이동]
            // 문자가 'C'면 'C'-'A' = 2가 됨 -> 두 번의 이동이 있다는 의미
            // 문자가 'B'면 'Z'-'B'+1 = 25가 됨 -> 반시계 방향으로 25번의 이동이 있다는 의미
	        answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // [좌우이동]
            // 오른쪽으로 가다가 A 만나면 왼쪽으로 이동
            // 이동횟수 = (A 만나기 전까지의 오른쪽 이동횟수) + (왼쪽 이동횟수)
            move = Math.min(move, (i * 2) + name.length() - next); // 왼쪽으로 갔다가 오른쪽으로 감
            move = Math.min(move, (name.length() - next) * 2 + i); // 오른쪽 갔다가 돌아옴
        }
        
        return answer += move;
    }
}