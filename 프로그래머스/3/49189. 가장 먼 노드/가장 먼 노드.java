import java.util.*;

public class Edge {
    int start;
    int end;
        
    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 그래프를 인접 리스트로 변환
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        // 방문 여부와 거리를 기록할 배열
        boolean[] isVisited = new boolean[n+1];
        int[] distances = new int[n+1];
        isVisited[1] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (!isVisited[neighbor]) {
                    isVisited[neighbor] = true;
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // 최대 거리를 찾고, 그 거리를 가진 노드의 수를 계산
        int maxVal = 0;
        for (int distance : distances) {
            if (distance > maxVal) {
                maxVal = distance;
                answer = 1;
            } else if (distance == maxVal) {
                answer++;
            }
        }
        
        return answer;
    }
}
