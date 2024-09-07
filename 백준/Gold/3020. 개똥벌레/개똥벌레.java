import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;
    int N, H;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 14
        H = Integer.parseInt(st.nextToken()); // 5

        int[] low = new int[N/2];
        int[] high = new int[N/2];

        for (int i = 0; i < N/2; i++) {
            low[i] = Integer.parseInt(br.readLine());
            high[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(low); // 1 2 3 3 3 3 4
        Arrays.sort(high); // 2 2 3 3 3 4 4

        int minObstaclesCnt = N;
        int intervalCnt = 0;

        for (int i = 1; i <= H; i++) {
            int obstaclesCnt = getObstaclesCnt(low, i, true) + getObstaclesCnt(high, i, false);

            if (obstaclesCnt < minObstaclesCnt) {
                minObstaclesCnt = obstaclesCnt;
                intervalCnt = 1;
            } else if (obstaclesCnt == minObstaclesCnt) {
                intervalCnt++;
            }
        }

        System.out.println(minObstaclesCnt + " " + intervalCnt);
    }

    private int getObstaclesCnt(int[] arr, int h, boolean isLow) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (isLow) {
                if (arr[mid] >= h) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (arr[mid] >= H - h + 1) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return arr.length - l;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}