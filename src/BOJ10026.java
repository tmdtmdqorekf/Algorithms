import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair5 {
    int x, y;
    public Pair5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ10026 {
    int ans1 = 0, ans2 = 0, N;
    char[][] map1, map2;
    boolean[][] isVisited1, isVisited2;

    Queue<Pair5> q = new LinkedList<>();

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 맵 세팅 for 적록색약 X
        map1 = new char[N][N];
        isVisited1 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map1[i][j] = s.charAt(j);
            }
        }

        // 맵 세팅 for 적록색약
        map2 = new char[N][N];
        isVisited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map1[i][j] == 'R' || map1[i][j] == 'G') {
                    map2[i][j] = 'S';
                } else {
                    map2[i][j] = 'B';
                }
            }
        }

        // 적록색약이 아닌 경우 - R / G / B
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                if (!isVisited1[i][j]) {
                    bfs(i, j, map1, isVisited1);
                    ans1++;
                }
            }
        }

        // 적록색약인 경우 - R+G / B
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                if (!isVisited2[i][j]) {
                    bfs(i, j, map2, isVisited2);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public void bfs(int x, int y, char[][] map, boolean[][] isVisited) {
        q.add(new Pair5(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Pair5 curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                // 범위를 벗어난 경우 예외처리
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                // 이미 방문한 경우 예외처리
                if (isVisited[nx][ny]) {
                    continue;
                }

                // 색상이 같지 않은 경우 탐색 종료
                if (map[curr.x][curr.y] != map[nx][ny]) {
                    continue;
                }

                q.add(new Pair5(nx, ny));
                isVisited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ10026().solution();
    }
}
