import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair4 {
    int x, y;
    public Pair4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ1012 {
    int ans, T, M, N, K;
    int[][] map;
    int[][] isVisited;

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            // 초기화
            ans = 0;
            map = new int[M][N];
            isVisited = new int[M][N];

            // 배추 위치 표시
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st2.nextToken());
                int Y = Integer.parseInt(st2.nextToken());
                map[X][Y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && isVisited[i][j] == 0) {
                        Queue<Pair4> q = new LinkedList<>();
                        q.add(new Pair4(i, j)); // 시작점 설정
                        isVisited[i][j] = 1; // 현위치 방문 표시

                        // BFS
                        while (!q.isEmpty()) {
                            Pair4 curr = q.poll();

                            // 상우하좌 탐색
                            for (int k = 0; k < 4; k++) {
                                int nx = curr.x + dx[k];
                                int ny = curr.y + dy[k];

                                // 범위 밖을 벗어난 경우 예외처리
                                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                                    continue;
                                }

                                // 이미 방문했거나 배추가 없는 경우 예외처리
                                if (isVisited[nx][ny] == 1 || map[nx][ny] == 0) {
                                    continue;
                                }

                                isVisited[nx][ny] = 1;
                                q.add(new Pair4(nx, ny));
                            }
                        }
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ1012().solution();
    }
}
