import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    ArrayList<Integer> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 아이들 수
        M = Integer.parseInt(st.nextToken()); // 색상 수

        // 보석 수 저장
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            r = Math.max(r, n);
        }

        // 보석 수 내림차순 정렬
        list.sort(Collections.reverseOrder());

        int answer = r; // 일단 최대로 설정
        while (l <= r) {
            int cnt = 0;
            int mid = (l + r) / 2; // 질투심 가정

            for (int i = 0; i < M; i++) {
                int K = list.get(i);

                // 보석 나누어주기
                cnt += (K + mid - 1) / mid;

                if (cnt > N) {
                    l = mid + 1;
                    break;
                }
            }

            if (cnt <= N) {
                answer = mid;
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
