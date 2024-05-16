import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair1 {
    int x, y;
    public Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ7576 {
    int[][] box;
    int[][] dist;
    int minDay = 0;

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<Pair1> q = new LinkedList<>();

        box = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st2.nextToken());

                // 익은 토마토인 경우
                if (box[i][j] == 1) {
                    q.add(new Pair1(i, j));
                }
                // 익지 않은 토마토인 경우
                if (box[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Pair1 curr = q.remove();
            box[curr.x][curr.y] = -1; // 방문 체크

            for (int k = 0; k < 4; k++) {
                int nextX = curr.x + dx[k];
                int nextY = curr.y + dy[k];

                // 범위를 벗어나는 경우
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                // 이미 방문했거나 빈 칸인 경우
                if (dist[nextX][nextY] != -1) {
                    continue;
                }

                // 로직
                q.add(new Pair1(nextX, nextY));
                dist[nextX][nextY] = dist[curr.x][curr.y] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                minDay = Math.max(minDay, dist[i][j]);
            }
        }
        System.out.println(minDay);
    }

    public static void main(String[] args) throws Exception {
        new BOJ7576().solution();
    }
}