import java.util.*;

class Rectangle {
    int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // 주어진 좌표(x, y)가 사각형 내부에 있는지 확인
    public boolean isIn(int x, int y) {
        if (x1 < x && x < x2 && y1 < y && y < y2) {
            return true;
        }
        return false;
    }
}

class Solution {
    int[][] map = new int[102][102];
    List<Rectangle> rects = new ArrayList<>();
    
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            // 칸이 작으면 이어지면 안될 부분이 이어질 수 있기 때문에
            // 좌표를 2배로 키우기
            int xmin = rec[0] * 2;
            int ymin = rec[1] * 2;
            int xmax = rec[2] * 2;
            int ymax = rec[3] * 2;
            
            // 사각형을 리스트에 추가
            rects.add(new Rectangle(xmin, ymin, xmax, ymax));
            
            // 맵 그리기 (중첩된 영역은 -1로 유지)
            for (int x = xmin; x <= xmax; x++) {
                for (int y = ymin; y <= ymax; y++) {
                    map[x][y] -= 1;
                }
            }
        }

        int cx = characterX * 2;
        int cy = characterY * 2;
        int ix = itemX * 2;
        int iy = itemY * 2;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { cx, cy, 1 }); // 캐릭터 시작 위치 & 거리 정보
        
        int nx = 0;
        int ny = 0;
        
        // BFS를 통해 최단 경로 탐색
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cx = curr[0];
            cy = curr[1];
            
            // 캐릭터가 아이템 위치에 도달한 경우, 이동 거리를 반환
            if (cx == ix && cy == iy) {
                return (curr[2] - 1) / 2; // 반으로 나누어 반환
            }
            
            // 현재 위치를 방문 처리 (거리 정보 기록)
            map[cx][cy] = curr[2];
            
            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                nx = cx + dr[i];
                ny = cy + dc[i];
                
                // 새 좌표가 유효하고, 아직 방문하지 않았으며, 내부에 있지 않은 경우
                if (map[nx][ny] < 0 && !inRect(nx, ny)) {
                    q.add(new int[] {nx, ny, curr[2] + 1});
                }
            }
        }
        return -1; // 아이템을 찾을 수 없는 경우
    }

    // 주어진 좌표가 어떤 사각형의 내부에 있는지 확인하는 메서드
    private boolean inRect(int nx, int ny) {
        for (Rectangle r : rects) {
            if (r.isIn(nx, ny)) {
                return true;
            }
        }
        return false;
    }
}