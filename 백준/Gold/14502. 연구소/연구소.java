import java.io.*;
import java.util.*;

class Virus {
    int x, y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int N, M;
    int maxSafetyZone = Integer.MIN_VALUE;
    int[][] map;

    Queue<Virus> q = new LinkedList<>();

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (n == 2) {
                    q.add(new Virus(i, j));
                }
            }
        }

        permutation(3, 0);

        System.out.println(maxSafetyZone);
    }

    private void permutation(int depth, int r) {
        if (depth == r) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    permutation(depth, r + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void spreadVirus() {
        // 깊은 복사를 하려면 각 행 별로 복사해야함
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        // 이렇게 하면 q를 copy할 수 있음
        Queue<Virus> qCopy = new LinkedList<>(q);

        while (!qCopy.isEmpty()) {
            Virus curr = qCopy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && newMap[nx][ny] == 0) {
                    qCopy.add(new Virus(nx, ny));
                    newMap[nx][ny] = 2;
                }
            }
        }

        countSafetyZone(newMap);
    }

    private void countSafetyZone(int[][] newMap) {
        int safetyZone = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    safetyZone++;
                }
            }
        }

        maxSafetyZone = Math.max(maxSafetyZone, safetyZone);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}