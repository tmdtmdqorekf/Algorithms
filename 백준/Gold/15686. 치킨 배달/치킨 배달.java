import java.io.*;
import java.util.*;

class Location {
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    int N, M;
    int minDist = Integer.MAX_VALUE;

    int[][] map;
    boolean[] openChicken;
    ArrayList<Location> home = new ArrayList<>();
    ArrayList<Location> chicken = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (n == 1) {
                    home.add(new Location(i, j));
                }
                else if (n == 2) {
                    chicken.add(new Location(i, j));
                }
            }
        }

        // 최대 M개 살리기
        openChicken = new boolean[chicken.size()];
        selectOpen(0, 0);

        System.out.println(minDist);
    }

    // 폐업시키지 않을 치킨집 수 = 최대 2개
    //   0       1        2
    // (1,2)   (3,3)    (5,5)
    // 2개 살림 -> 01, 02, 12
    // 각각 calcDist 해보고 min보다 크면 back
    // 1개 살림 -> 0, 1, 2
    // calcDist -> back
    // 0개 살림 -> 다 out
    // calcDist -> back

    // 최대 M개의 치킨집 열기, (2의 전체 개수 - i)개 폐업시키기
    private void selectOpen(int idx, int maxOpenCnt) {
        if (maxOpenCnt == M) {
            calcDist();
            return;
        }

        if (idx == chicken.size()) {
            return;
        }

        // open
        openChicken[idx] = true;
        selectOpen(idx + 1, maxOpenCnt + 1);

        // back
        openChicken[idx] = false;
        selectOpen(idx + 1, maxOpenCnt);
    }

    // 집-치킨집 거리 계산 (bfs로 가장 가까운 곳 선택)
    private void calcDist() {
        int totalDist = 0;

        for (Location h : home) {
            int homeDist = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if (openChicken[i]) {
                    Location c = chicken.get(i);
                    int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                    // 가장 가까운 치킨집 거리
                    homeDist = Math.min(homeDist, dist);
                }
            }
            totalDist += homeDist;
        }

        minDist = Math.min(minDist, totalDist);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
