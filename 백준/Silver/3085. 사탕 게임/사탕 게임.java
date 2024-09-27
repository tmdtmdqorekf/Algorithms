import java.io.*;
import java.util.*;

class Candy {
    int x, y;

    public Candy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int N, max;
    char[][] map;

    // 상우하좌
    int[] dx = {1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 초기화
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 좌우 swap + 백트래킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                calculate();
                swap(i, j + 1, i, j);
            }
        }

        // 상하 swap + 백트래킹
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                calculate();
                swap(i + 1, j, i, j);
            }
        }

        System.out.println(max);
    }

    private void swap(int i1, int j1, int i2, int j2) {
        char tmp = map[i1][j1];
        map[i1][j1] = map[i2][j2];
        map[i2][j2] = tmp;
    }

    private void calculate() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j+1]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j+1][i]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}