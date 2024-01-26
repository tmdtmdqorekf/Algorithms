import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    int[][] arr;
    int N, M, V;
    boolean[] isVisited;

    public void DFS(int x) {
        isVisited[x] = true;
        System.out.print(x + " ");

        for (int i = 1; i <= N; i++) {
            if ((arr[x][i] == 1 || arr[i][x] == 1) && !isVisited[i]) {
                DFS(i);
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 인접 행렬 (간선 잇기)
        arr = new int[N+1][N+1];
        for (int i = 1; i <= M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            arr[u][v] = arr[v][u] = 1; // 간선은 양방향
        }

        // DFS (재귀)
        isVisited = new boolean[N+1];
        DFS(V);
        System.out.println();

        // BFS (큐)
        Queue<Integer> q = new LinkedList<>();
        isVisited = new boolean[N+1];

        q.add(V);
        isVisited[V] = true;

        while (!q.isEmpty()) {
            int k = q.poll();
            System.out.print(k + " ");

            for (int i = 1; i <= N; i++) {
                if ((arr[k][i] == 1 || arr[i][k] == 1) && !isVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ1260().solution();
    }
}
