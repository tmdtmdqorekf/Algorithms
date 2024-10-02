import java.io.*;
import java.util.*;

class Virus2 {
    int v, x, y, cnt;

    public Virus2(int v, int x, int y, int cnt) {
        this.v = v;
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    int N, K, S, X, Y;
    int[][] map;
    boolean[][] isVisited;

    PriorityQueue<Virus2> pq = new PriorityQueue<>(new Comparator<Virus2>() {
        @Override
        public int compare(Virus2 o1, Virus2 o2) {
            if (o1.cnt != o2.cnt) {
                return o1.cnt - o2.cnt;
            } else {
                return o1.v - o2.v;
            }
        }
    });

    // 상하좌우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 맵 크기
        K = Integer.parseInt(st.nextToken()); // 바이러스 수

        map = new int[N+1][N+1];
        isVisited = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n != 0) {
                    pq.add(new Virus2(n, i, j, 1));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 시간
        X = Integer.parseInt(st.nextToken()); // X좌표
        Y = Integer.parseInt(st.nextToken()); // Y좌표

        bfs();
        
        System.out.println(map[X][Y]);
    }

    private void bfs() {
        while (S-- > 0) {
            int size = pq.size();
            for (int s = 0; s < size; s++) {
                Virus2 curr = pq.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = curr.v;
                            pq.add(new Virus2(curr.v, nx, ny, curr.cnt + 1));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}