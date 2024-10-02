import java.io.*;
import java.util.*;

public class Main {
    int N, M;
    int[] arr;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, arr[i]);
        }

        binarySearch(l, r);
    }

    private void binarySearch(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;

            int cnt = 1;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if (max - min > mid) {
                    cnt++;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    i--;
                }
            }

            if (cnt <= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}