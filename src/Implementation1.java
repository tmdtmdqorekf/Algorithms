import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Implementation1 {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5
        char[] plans = br.readLine().toCharArray(); // R R R U D D

        // 동 북 서 남 (R U L D)
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        char[] moveTypes = {'R', 'U', 'L', 'D'};

        // 현재 위치
        int currX = 1, currY = 1;

        // 이동
        for (char plan : plans) {
            int nextX = -1, nextY = -1; // 초기화
            for (int j = 0; j < 4; j++) { // 전체 탐색해서 다음 이동 좌표 찾기
                if (plan == moveTypes[j]) {
                    nextX = currX + dx[j];
                    nextY = currY + dy[j];
                }
            }

            // 범위를 벗어나는 경우 무시
            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) {
                continue;
            }

            // 범위를 벗어나지 않는 경우 이동
            currX = nextX;
            currY = nextY;
        }

        System.out.println(currX + " " + currY);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Implementation1().solution();
    }
}

/*

동 북 서 남 (R U L D)
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

시작 좌표 (1, 1)

범위 벗어나는 움직임은 무시

 */