import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair2 {
    int x, y;
    public Pair2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ4179 {
    char[][] maze;
    int[][] distF;
    int[][] distJ;
    int R = 0, C = 0, tmp = 0;

    // 상 우 하 좌
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0 , 1, 0};

    private boolean isNotMet(int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (distF[i][j] == 0) {
                    tmp += 1;
                }
            }
        }
        return tmp >= 2; // true
    }

    private boolean isOutOfRange(int nextX, int nextY) {
        return nextX < 0 || nextX >= R || nextY < 0 || nextY >= C; // true
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];

        // 초기 세팅
        for(int i = 0; i < R; i++) {
            Arrays.fill(distF[i], -1);
            Arrays.fill(distJ[i], -1);
        }

        Queue<Pair2> qf = new LinkedList<>();
        Queue<Pair2> qj = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char x = s.charAt(j);
                maze[i][j] = x;
                if (x == 'F') {
                    distF[i][j] = 0;
                    qf.add(new Pair2(i, j));
                }
                if (x == 'J') {
                    // 바로 옆이 탈출구인 경우
                    if (isOutOfRange(i, j)) {
                        System.out.println(1);
                        return;
                    }
                    distJ[i][j] = 0;
                    qj.add(new Pair2(i, j));
                }
            }
        }

        // 불 전파 시간 설정
        while (!qf.isEmpty()) {
            Pair2 curr = qf.remove(); // (2, 1)

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                // 범위 밖인 경우
                if (isOutOfRange(nextX, nextY)) {
                    continue;
                }
                // 벽이거나 이미 방문한 경우
                if (maze[nextX][nextY] == '#' || distF[nextX][nextY] >= 0) {
                    continue;
                }

                qf.add(new Pair2(nextX, nextY));
                distF[nextX][nextY] = distF[curr.x][curr.y] + 1;
            }
        }

        // 지훈 이동 시간 설정
        while (!qj.isEmpty()) {
            Pair2 curr = qj.remove(); // (1, 1)

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                // 범위 밖인 경우
                if (isOutOfRange(nextX, nextY)) {
                    if (distJ[curr.x][curr.y] < distF[curr.x][curr.y]) {
                        System.out.println(distJ[curr.x][curr.y] + 1);
                        return;
                    }
                    // 애초에 불과 지훈이 만날 수 없는 경우
                    if (!isNotMet(R, C)) {
                        System.out.println(distJ[curr.x][curr.y] + 1);
                        return;
                    }
                    continue;
                }

                // 벽이거나 이미 방문한 경우
                if (maze[nextX][nextY] == '#' || distJ[nextX][nextY] > 0) {
                    continue;
                }

                // 불의 전파 시간을 조건에 추가 (동시에 도착하거나, 불이 먼저 도착해있는 경우)
                if (distF[nextX][nextY] != -1 && distF[nextX][nextY] <= distJ[curr.x][curr.y] + 1) {
                    continue;
                }

                qj.add(new Pair2(nextX, nextY));
                distJ[nextX][nextY] = distJ[curr.x][curr.y] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws Exception {
        new BOJ4179().solution();
    }
}