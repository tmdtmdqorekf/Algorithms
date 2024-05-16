import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    int[][] arr;
    int N, M;
    boolean[][] isVisited;

    int[] dx = {-1, 1, 0, 0}; // 상, 하
    int[] dy = {0, 0, -1, 1}; // 좌, 우

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 행렬 설정 (단방향)
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0'; // 공백 없는 문자 split 해서 받기
            }
        }

        // BFS
        Queue<int[]> q = new LinkedList<>(); // 배열도 큐로 저장 가능 !!
        q.add(new int[] {0, 0}); // 이렇게 초기화 !

        isVisited = new boolean[N][M];
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (isVisited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new int[] {nextX, nextY});
                arr[nextX][nextY] = arr[currX][currY] + 1;
                isVisited[nextX][nextY] = true;
            }
        }

        System.out.print(arr[N-1][M-1]);
    }

    public static void main(String[] args) throws Exception {
        new BOJ2178().solution();
    }
}
