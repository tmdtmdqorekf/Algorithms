import java.io.*;
import java.util.*;

public class Main {
    long answer;
    long N, M;
    ArrayList<Long> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list);

        long l = 1; // 7 -> 최적의 경우
        long r = list.get(list.size() - 1) * M; // 10 * 6 = 60 -> 최악의 경우의 수

        while (l <= r) {
            long mid = (l + r) / 2; // (7 + 60) / 2 = 33

            long complete = 0;
            for (int i = 0; i < N; i++) {
                complete += (mid / list.get(i)); // (33 / 7) + (33 / 10) = 7

                if (complete >= M) {
                    break;
                }
            }

            if (complete < M) { // 7 < 6 (X)
                l = mid + 1;
            } else { // 7 >= 6 (O)
                r = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}