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

        // 인접리스트 초기화
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            list.get(e[0]).add(e[1]); // 간선의 시작 노드에서 끝 노드로 연결
            list.get(e[1]).add(e[0]); // 양방향 그래프이므로 반대 방향도 추가
        }
        
        Queue<Edge> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        int[] dist = new int[n+1]; // 1부터 각 노드까지의 최단 거리 저장

        q.add(new Edge(1, 1));
        isVisited[1] = true;
        
        while (!q.isEmpty()) {
            Edge curr = q.poll();

            // 현재 노드에 연결된 모든 이웃 노드 찾기
            for (int neighbor : list.get(curr.end)) {
                if (!isVisited[neighbor]) {
                    isVisited[neighbor] = true;
                    dist[neighbor] = dist[curr.end] + 1;
                    q.add(new Edge(curr.end, neighbor)); // 이웃 노드 큐에 추가
                }
            }
        }
        
        int maxVal = 0;
        for (int d : dist) {
            if (d > maxVal) {
                maxVal = d;
                answer = 1;
            } else if (d == maxVal) {
                answer++;
            }
        }
        
        return answer;
    }
}