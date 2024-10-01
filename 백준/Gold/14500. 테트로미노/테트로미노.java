import java.io.*;
import java.util.*;


public class Main {
    int N, M, answer;
    int[][] map;

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, map[i][j], isVisited);
                isVisited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(answer);
    }

    private void dfs(int x, int y, int r, int sum, boolean[][] isVisited) {
        if (r >= 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !isVisited[nx][ny]) {
                isVisited[nx][ny] = true;
                dfs(nx, ny, r + 1, sum + map[nx][ny], isVisited);
                isVisited[nx][ny] = false;
            }
        }
    }

    private void check(int x, int y) {
        if (x < N - 2 && y < M - 1) {
            answer = Math.max(answer, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);
        }
        if (x < N - 2 && y > 0) {
            answer = Math.max(answer, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);
        }
        if (x < N - 1 && y < M - 2) {
            answer = Math.max(answer, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);
        }
        if (x > 0 && y < M - 2) {
            answer = Math.max(answer, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
