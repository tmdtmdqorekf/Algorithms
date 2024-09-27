import java.io.*;
import java.util.*;

public class Main {
    int N, K;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 2 3 4 5 6 7
        // 2 = P 소수
        // 2 지우기 -> 4, 6 지우기
        // 3 = P 소수
        // 3 지우기 -> 6 지우기 (이미 지워졌으면 패스)

        int[] arr = new int[N+1];
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i; j <= N; j += i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    K--;

                    if (K == 0) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}