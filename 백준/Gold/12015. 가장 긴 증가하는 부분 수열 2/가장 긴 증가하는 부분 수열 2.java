import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    int[] nums;
    int[] len;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        len = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(len, 0, maxLen, nums[i]);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            len[idx] = nums[i];

            if (idx == maxLen) {
                maxLen++;
            }
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}