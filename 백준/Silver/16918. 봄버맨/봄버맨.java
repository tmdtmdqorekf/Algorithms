import java.io.*;
import java.util.*;

class Bomb {
    int x, y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int R, C, N;
    int time = 1;
    char[][] map;
    int[][] bombTime;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bombTime = new int[R][C]; // 폭탄 폭발 시간
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bombTime[i][j] = 3;
                }
            }
        }

        // 시간이 1초면 그대로 출력
        if (N == 1) {
            printMap();
            return;
        }

        while (time++ < N) {
            // 1 - do nothing
            // 2 - install bomb
            // 3 - explosion

            if (time % 2 == 0) { // 2
                installAllBomb();
            } else { // 1 or 3
                explosion();
            }
        }

        printMap();  // 최종 상태 출력
    }

    private void installAllBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombTime[i][j] = time + 3;
                }
            }
        }
    }

    private void explosion() {
        Queue<Bomb> q = new LinkedList<>();

        // 이번 시간에 폭발할 폭탄들 추가
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombTime[i][j] == time) {
                    q.add(new Bomb(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Bomb bomb = q.poll();
            map[bomb.x][bomb.y] = '.';
            bombTime[bomb.x][bomb.y] = 0; // 폭탄 시간 0으로 초기화

            for (int i = 0; i < 4; i++) {
                int nx = bomb.x + dx[i];
                int ny = bomb.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                        map[nx][ny] = '.';
                        bombTime[nx][ny] = 0;
                    }
                }
            }
        }
    }

    private void printMap() {
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
