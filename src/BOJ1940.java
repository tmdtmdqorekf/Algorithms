import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 난 이렇게 풀었지만, 정렬해서 풀면 시간복잡도 줄어들 수 있음
public class BOJ1940 {
    int[] arr;
    int sum = 0, cnt = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long M = Long.parseLong(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum = arr[i] + arr[j];

                if (sum == M) {
                    if (i != j) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1940().solution();
    }
}
