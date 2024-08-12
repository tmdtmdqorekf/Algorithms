import java.util.*;

class Plan {
    String name;
    int start, duration;
    
    public Plan(String name, int start, int duration) {
        this.name = name;
        this.start = start;
        this.duration = duration;
    }
}

class Solution {
    public ArrayList<String> solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        
        // 시작 시간 순으로 정렬
        PriorityQueue<Plan> pq = new PriorityQueue<>(new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                return o1.start - o2.start;
            }
        });
        
        // pq에 데이터 삽입
        for (String[] p : plans) {
            pq.add(new Plan(p[0], hourToMin(p[1]), Integer.parseInt(p[2])));
        }
        
        Stack<Plan> waitList = new Stack<>();
        Plan curr = pq.poll();
        int currTime = curr.start;

        while (!pq.isEmpty() || curr != null) {
            if (!pq.isEmpty() && (currTime + curr.duration) > pq.peek().start) {
                // 현재 과제를 멈추고 새로운 과제를 시작해야 하는 경우
                curr.duration -= pq.peek().start - currTime;
                currTime = pq.peek().start;
                waitList.push(curr);
                curr = pq.poll();
            } else {
                // 현재 과제를 끝낼 수 있는 경우
                currTime += curr.duration;
                answer.add(curr.name);
                curr = null;

                // 멈춰둔 과제가 있는 경우 이어서 진행
                if (!waitList.isEmpty()) {
                    curr = waitList.pop();
                } else if (!pq.isEmpty()) {
                    // 큐에서 새로운 과제를 가져옴
                    curr = pq.poll();
                    currTime = Math.max(currTime, curr.start);
                }
            }
        }

        return answer;
    }
    
    private int hourToMin(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return h * 60 + m;
    }
}
