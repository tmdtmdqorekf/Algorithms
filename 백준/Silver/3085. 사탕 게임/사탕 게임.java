import java.io.*;

public class Main {
    int N, candy;
    int maxCandy = Integer.MIN_VALUE;
    char[][] map;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 좌우 swap
                swap(i, j, i, j + 1);
                calculate();
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                // 상하 swap
                swap(i, j, i + 1, j);
                calculate();
                swap(i, j, i + 1, j);
            }
        }

        System.out.println(maxCandy);
    }

    // swap & back
    private void swap(int i1, int j1, int i2, int j2) {
        char tmp = map[i1][j1];
        map[i1][j1] = map[i2][j2];
        map[i2][j2] = tmp;
    }

    // 먹을 수 있는 사탕 수 계산
    private void calculate() {
        // 좌우 연속된 사탕 수
        for (int i = 0; i < N; i++) {
            candy = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j+1]) {
                    candy++;
                    maxCandy = Math.max(maxCandy, candy);
                } else {
                    candy = 1;
                }
            }
        }

        // 상하 연속된 사탕 수
        for (int i = 0; i < N; i++) {
            candy = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j+1][i]) {
                    candy++;
                    maxCandy = Math.max(maxCandy, candy);
                } else {
                    candy = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}