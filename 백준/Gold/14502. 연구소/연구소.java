import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int x, y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int N, M;
    int answer = Integer.MIN_VALUE;
    int[][] map;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    Queue<Virus> q = new LinkedList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 채우기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    q.add(new Virus(i, j));
                }
            }
        }

        // 3개 벽 조합
        combination(0);

        System.out.println(answer);
    }

    private void combination(int wallCnt) {
        if (wallCnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    combination(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void spreadVirus() {
        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            mapCopy[i] = map[i].clone();
        }
        
        Queue<Virus> qCopy = new LinkedList<>(q);

        while (!qCopy.isEmpty()) {
            Virus curr = qCopy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(mapCopy[nx][ny] == 0) {
                        mapCopy[nx][ny] = 2;
                        qCopy.add(new Virus(nx, ny));
                    }
                }
            }
        }

        calculate(mapCopy);
    }


    private void calculate(int[][] mapCopy) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapCopy[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        answer = Math.max(safeZone, answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}