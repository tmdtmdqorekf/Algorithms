import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    List<Long> lans = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            lans.add(Long.parseLong(br.readLine()));
        }

        lans.sort((o1, o2) -> Long.compare(o1, o2));

        long l = 1;
        long r = lans.get(K - 1);
        long mid = 0;
        long answer = 0;

        while (l <= r) {
            long lanCnt = 0;
            mid = (l + r) / 2; // 401

            for (int i = 0; i < K; i++) {
                lanCnt += lans.get(i) / mid;
            }

            if (lanCnt < N) {
                r = mid - 1;
            } else {
                answer = mid;
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}