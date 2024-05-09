import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    int N, M;
    int[] arr = new int[10];
    boolean[] isUsed = new boolean[10];

    public void func(int k) {
        // 수열이 완성된 경우
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 수열이 완성되지 않은 경우
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) { // 특정 숫자가 사용되지 않았다면
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);

                isUsed[i] = false; // 재귀 호출이 끝나면 i번째 수의 사용 여부를 원상 복귀
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 끝 숫자
        M = Integer.parseInt(st.nextToken()); // 수열 길이

        // 상태 공간 트리 0으로 시작
        func(0);
    }

    public static void main(String[] args) throws Exception {
        new BOJ15649().solution();
    }
}