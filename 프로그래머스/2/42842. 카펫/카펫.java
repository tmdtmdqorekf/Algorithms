import java.util.*;

class Pair {
    int x, y;
    
    public Pair(int x, int y) {
        this.x = x; // 가로
        this.y = y; // 세로
    }
}

class Solution {
    int yellowCnt = 0;
    
    Queue<Pair> q = new LinkedList<>();
    int[] answer = new int[2];

    public int[] solution(int brown, int yellow) {        
        int colorCnt = brown + yellow; // 12
        
        for (int i = 3; i <= Math.sqrt(colorCnt); i++) {
            if (colorCnt % i == 0) { // i가 12의 약수일 경우
                int n = colorCnt / i;
                q.add(new Pair(n, i));
            }
        }
        
        while (!q.isEmpty()) {
            Pair square = q.poll(); // (4, 3)
            int w = square.x;
            int h = square.y;
            
            yellowCnt = 0;
            for (int i = 1; i < w - 1; i++) {
                for (int j = 1; j < h - 1; j++) {
                    yellowCnt++;
                }
            }
            
            if (yellowCnt == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
}