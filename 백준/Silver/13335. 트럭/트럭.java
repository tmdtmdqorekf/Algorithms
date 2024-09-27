import java.io.*;
import java.util.*;


public class Main {
    int n, w, L;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken())); // 7, 4, 5, 8
        }

        // 다리 길이 만큼 초기 상태를 0으로 채움 (빈 칸)
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0); // 0 0
        }

        int totalTime = 0;
        int tw = 0;
        while (!bridge.isEmpty()) {
            totalTime++;

            tw -= bridge.poll(); // 0, 0, 7, 4

            if (!truck.isEmpty()) {
                if (tw + truck.peek() <= L) { // 0+7, 0+4, 4+5
                    tw += truck.peek(); // 7, 4
                    // 트럭이 다리 위에 올라감
                    bridge.add(truck.poll()); // 0 7 4
                } else { // 7+5
                    // 다리 위 무게가 초과되면 트럭을 올리지 않고 0을 추가 (빈 공간)
                    bridge.add(0); // 4 0
                }
            }
        }

        System.out.println(totalTime);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}