import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Robot {
    int r, c, d;
    public Robot(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}


public class BOJ14503 {
    int cleaned = 0, N, M;
    int[][] room;
    boolean[][] isVisited;

    Queue<Robot> q = new LinkedList<>();

    // 상 우 하 좌 - 0 1 2 3
    int[] dr = {-1, 0 , 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 좌표 r
        int c = Integer.parseInt(st.nextToken()); // 좌표 c
        int d = Integer.parseInt(st.nextToken()); // 바라보는 방향

        // 방 설정 - 0은 빈칸, 1은 벽
        room = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 로봇 청소기 위치 및 방향 설정
        q.add(new Robot(r, c, d)); // (7, 4, 0)

        while(!q.isEmpty()) {
            Robot curr = q.poll();

            // 1. 현재 칸이 청소되지 않은 경우 청소
            if (!isVisited[curr.r][curr.c]) {
                isVisited[curr.r][curr.c] = true;
                cleaned++;
            }

            // 주변 4칸 탐색
            boolean foundZero = false;
            for (int i = 0; i < 4; i++) {
                int nd = (curr.d + 3 - i) % 4;
                int nr = curr.r + dr[nd];
                int nc = curr.c + dc[nd];

                // 범위에 벗어났거나 벽이거나 이미 청소한 경우
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] == 1 || isVisited[nr][nc]) {
                    continue;
                }

                // 청소되지 않은 빈칸 count
                if (room[nr][nc] == 0) {
                    q.add(new Robot(nr, nc, nd));
                    foundZero = true;
                    break;
                }
            }

            // 2. 주변 4칸 중 청소되지 않은 빈 칸 없는 경우
            if (!foundZero) {
                int backd = (curr.d + 2) % 4;
                int backr = curr.r + dr[backd];
                int backc = curr.c + dc[backd];

                // 벗어나는 범위라 후진할 수 없는 경우 break
                if (backr < 0 || backr >= N || backc < 0 || backc >= M) {
                    break;
                }

                // 2-2. 뒤쪽 칸이 벽이면 break
                if (room[backr][backc] == 1) {
                    break;
                }

                // 2-1. 방향 유지, 후진
                q.add(new Robot(backr, backc, curr.d));

            }
        }

        System.out.println(cleaned);
    }

    public static void main(String[] args) throws Exception {
        new BOJ14503().solution();
    }
}
