import java.io.*;
import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CT_dxdy_1 {
    static int n, m, t, r, c;

    static int[][] arr = new int[21][21];
    static int[][] count = new int[21][21];
    static int[][] nextCount = new int[21][21];

    // 충돌 제거
    public static void remove() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] >= 2) {
                    count[i][j] = 0;
                }
            }
        }
    }

    // 범위 안에 있는지 확인
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    // 숫자가 가장 큰 위치 반환
    public static Pair getMaxNeighborPos(int currX, int currY) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int maxNum = 0;
        Pair maxPos = new Pair(-1, -1);

        // 각각의 방향에 대해 나아갈 수 있는 곳이 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            // 범위 안에 들어오는 격자 중 최댓값 갱신
            if (inRange(nextX, nextY) && arr[nextX][nextY] > maxNum) {
                maxNum = arr[nextX][nextY];
                maxPos = new Pair(nextX, nextY);
            }
        }

        return maxPos;
    }

    public static void move(int x, int y) {
        // 인접한 곳들 중 가장 값이 큰 위치 계산
        Pair nextPos = getMaxNeighborPos(x, y);
        int nextX = nextPos.x;
        int nextY = nextPos.y;

        nextCount[nextX][nextY] += 1;
    }

    public static void moveAll() {
        // n*n for next 구슬 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nextCount[i][j] = 0;
            }
        }

        // 구슬 위치 가서 이동
        // nextCount에 기록
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                if (count[i][j] == 1) {
                    move(i, j);
                }
            }
        }

        // nextCount값 count에 복사
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                count[i][j] = nextCount[i][j];
            }
        }
    }

    public static void simulate() {
        // 전체 한번 이동
        moveAll();

        // 충돌 제거
        remove();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        // n*n for 숫자
        for (int i = 1; i <= n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // n*n for current 구슬 위치
        for (int i = 1; i <= m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st3.nextToken());
            c = Integer.parseInt(st3.nextToken());
            count[r][c] = 1;
        }

        // t초 동안 시뮬레이션 진행
        while (t-- > 0) {
            simulate();
        }

        // 출력
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans += count[i][j];
            }
        }
        System.out.print(ans);
    }
}