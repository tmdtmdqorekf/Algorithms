import java.io.*;
import java.util.*;

class P {
    int x, y, dist;

    public P(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    int N, M;
    int[][] map;
    boolean[][] isVisited;

    // 상하좌우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

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

        int maxDist = Integer.MIN_VALUE; // 가장 긴 경로 길이
        int maxSum = Integer.MIN_VALUE; // 끝과 끝의 최대 합

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) { // 0이 아닌 방에서만 탐색 시작
                    int[] result = bfs(i, j);

                    int dist = result[0];
                    int sum = result[1];

                    // 더 긴 경로를 찾았을 때 업데이트
                    if (dist > maxDist || (dist == maxDist && sum > maxSum)) {
                        maxDist = dist;
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum); // 비밀번호 출력
    }

    // BFS를 사용하여 최단 경로 중 가장 긴 경로 찾기
    private int[] bfs(int x, int y) {
        isVisited = new boolean[N][M];
        Queue<P> q = new LinkedList<>();
        q.add(new P(x, y, 0));
        isVisited[x][y] = true;

        int maxDist = 0;
        int maxSum = map[x][y];

        while (!q.isEmpty()) {
            P curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (isVisited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                isVisited[nx][ny] = true;
                q.add(new P(nx, ny, curr.dist + 1));

                // 경로의 길이가 길거나, 같은 길이일 때는 합이 큰 것 선택
                int currDist = curr.dist + 1;
                int currSum = map[x][y] + map[nx][ny];
                if (currDist > maxDist || (currDist == maxDist && currSum > maxSum)) {
                    maxDist = currDist;
                    maxSum = currSum;
                }
            }
        }

        return new int[] {maxDist, maxSum};
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
