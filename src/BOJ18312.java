import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18312 {
    int result = 0;

    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if (h / 10 == K || m / 10 == K || s / 10 == K || h % 10 == K || m % 10 == K || s % 10 == K) {
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new BOJ18312().solution();
    }
}

/*

분/초는 60까지만 카운트 됨

초가 60이 되면 초를 0으로 초기화, 분++
분이 60이 되면 분을 0으로 초기화, 시++
시==N+1 되면 break

 */