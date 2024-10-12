import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        // 시작 좌표는 가운데
        int x = (N / 2);
        int y = (N / 2);

        int targetX = x; // 초기화
        int targetY = y; // 초기화

        map[x][y] = 1; // 중앙에 1 배치

        int step = 1;  // 처음에는 한 칸씩 이동
        int value = 1;

        while (value < N * N) {
            // 위로 이동
            for (int i = 0; i < step && value < N * N; i++) {
                x--;
                map[x][y] = ++value;
                if (value == target) {
                    targetX = x;
                    targetY = y;
                }
            }

            // 오른쪽으로 이동
            for (int i = 0; i < step && value < N * N; i++) {
                y++;
                map[x][y] = ++value;
                if (value == target) {
                    targetX = x;
                    targetY = y;
                }
            }

            step++;  // 한 번의 이동 후 step 증가

            // 아래로 이동
            for (int i = 0; i < step && value < N * N; i++) {
                x++;
                map[x][y] = ++value;
                if (value == target) {
                    targetX = x;
                    targetY = y;
                }
            }

            // 왼쪽으로 이동
            for (int i = 0; i < step && value < N * N; i++) {
                y--;
                map[x][y] = ++value;
                if (value == target) {
                    targetX = x;
                    targetY = y;
                }
            }

            step++;  // 두 번의 이동 후 step 증가
        }

        // 배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // target의 좌표 출력 (1-based 좌표)
        System.out.println((targetX + 1) + " " + (targetY + 1));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
