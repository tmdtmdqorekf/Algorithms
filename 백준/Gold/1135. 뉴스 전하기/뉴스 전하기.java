import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 직원의 부하를 저장할 리스트 배열
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1; // 루트 노드를 저장할 변수

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; // 루트 노드를 설정
            } else {
                adjList[parent].add(i);  // 부모에 자식을 추가
            }
        }

        // 루트 노드에서 DFS를 시작
        int answer = dfs(root, adjList);

        System.out.println(answer);
    }

    private int dfs(int node, List<Integer>[] adjList) {
        // 자식 노드가 없으면 0 반환
        if (adjList[node].isEmpty()) {
            return 0;
        }

        // 모든 자식 노드의 깊이를 계산하고 전파 시간을 고려한 최댓값을 반환
        List<Integer> times = new ArrayList<>();
        for (int child : adjList[node]) {
            times.add(dfs(child, adjList));
        }

        // 자식들에게 전파하는 데 걸리는 시간의 순서를 고려하여 정렬
        Collections.sort(times, Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < times.size(); i++) {
            maxTime = Math.max(maxTime, times.get(i) + i + 1);
        }

        return maxTime;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}