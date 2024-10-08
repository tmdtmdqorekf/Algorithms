import java.io.*;
import java.util.*;

public class Main {
    int N;
    long sum;
    long answer = 0;
    int[] arr;
    long[] toRightSum, toLeftSum;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        toRightSum = new long[N];
        toLeftSum = new long[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            sum += n;
            toRightSum[i] = sum;
        }

        int tmp = 0;
        for (int i = N - 1; i >= 0; i--) {
            tmp += arr[i];
            toLeftSum[i] = tmp;
        }

        case1();
        case2();
        case3();

        System.out.println(answer);
    }

    // 벌통 오른쪽 고정, B1 왼쪽 고정 -> B2 이동
    private void case1() {
        long b1, b2;

        for (int i = 1; i < N - 1; i++) {
            b1 = sum - arr[0] - arr[i];
            b2 = sum - toRightSum[i];
            answer = Math.max(answer, b1 + b2);
        }
    }

    // 벌통 왼쪽 고정, B1 오른쪽 고정 - > B2 이동
    private void case2() {
        long b1, b2;

        for (int i = N - 2; i >= 1; i--) {
            b1 = sum - arr[N-1] - arr[i];
            b2 = sum - toLeftSum[i];
            answer = Math.max(answer, b1 + b2);
        }
    }

    // B1, B2 양쪽 고정 -> 벌통 이동
    private void case3() {
        long b1, b2;

        for (int i = 1; i < N - 1; i++) {
            b1 = toRightSum[i] - arr[0];
            b2 = toLeftSum[i] - arr[N-1];
            answer = Math.max(answer, b1 + b2);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
