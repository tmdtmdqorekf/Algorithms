import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;
    List<Long> houses = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            houses.add(Long.parseLong(br.readLine()));
        }

        houses.sort(Long::compare);

        long l = 1; // 최소 거리
        long r = houses.get(N - 1) - houses.get(0); // 최대 거리
        long answer = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long prev = houses.get(0);
            int wifi = 1;

            for (int i = 1; i < N; i++) {
                if (houses.get(i) - prev >= mid) {
                    wifi++;
                    prev = houses.get(i);
                }
            }

            if (wifi >= C) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
