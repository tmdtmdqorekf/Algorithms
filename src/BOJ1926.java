import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair0 {
    int x, y;
    public Pair0(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ1926 {
    int num = 0, maxWidth = 0;
    int[][] canvas;
    boolean[][] isVisited;
    Queue<Pair0> q = new LinkedList<>();

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 도화지에 값 채우기
        canvas = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 도화지에 그림이 없는 경우
                if (canvas[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                num += 1;
                isVisited[i][j] = true; // 방문 체크
                q.add(new Pair0(i, j)); // 현재 위치 q에 추가

                // BFS 시작
                int tmp = 0;
                while (!q.isEmpty()) { // (0, 0)
                    Pair0 curr = q.remove();
                    tmp += 1;

                    // 현재 위치 기준으로 방향별로 탐색
                    for (int k = 0; k < 4; k++) {
                        int nextX = curr.x + dx[k];
                        int nextY = curr.y + dy[k];

                        // 범위에서 벗어나면 그 방향은 탐색 x
                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                            continue;
                        }

                        if (!isVisited[nextX][nextY] && canvas[nextX][nextY] == 1) {
                            q.add(new Pair0(nextX, nextY));
                            isVisited[nextX][nextY] = true;
                        }
                    }
                }
                maxWidth = Math.max(maxWidth, tmp);
            }
        }

        System.out.println(num);
        System.out.println(maxWidth);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1926().solution();
    }
}