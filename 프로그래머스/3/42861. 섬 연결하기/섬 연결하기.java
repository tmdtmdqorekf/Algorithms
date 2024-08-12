import java.util.*;

class Edge {
    int from, to, dist;

    public Edge(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // union-find 초기화: 각 노드의 부모를 자기 자신으로 설정
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        for (int[] cost : costs) {
            pq.add(new Edge(cost[0], cost[1], cost[2]));
        }

        int edgeCnt = 0; // MST에 포함된 간선 수
        while (!pq.isEmpty() && edgeCnt < n - 1) {
            Edge edge = pq.poll(); // 가장 가중치가 작은 간선 선택

            // 두 노드가 다른 집합에 속해 있는 경우에만 선택
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to); // 두 노드를 같은 집합으로 병합
                
                edgeCnt++;
                
                answer += edge.dist;
            }
        }

        return answer;
    }

    // find: 루트 노드 찾기
    private int find(int node) {
        // 자기 자신이 루트인 경우
        if (parent[node] == node) {
            return node;
        }
        
        return parent[node] = find(parent[node]);
    }
    
    // union: 두 집합 병합
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        
        if (root1 != root2) {
            parent[root2] = root1; // 루트1을 루트2의 부모로 설정
        }
    }
}