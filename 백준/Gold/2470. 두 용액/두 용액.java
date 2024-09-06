import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;
    StringBuilder sb;
    List<Long> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        list.sort(Long::compare);

        int l = 0;
        int r = N - 1;
        long sum = 0, sum2 = Long.MAX_VALUE;
        long answerL = 0, answerR = 0;

        while (l < r) {
            sum = list.get(l) + list.get(r);

            if (Math.abs(sum) < Math.abs(sum2)) {
                 sum2 = sum;
                 answerL = list.get(l);
                 answerR = list.get(r);
            }

            if (sum < 0) { // 합이 음수인 경우
                l++;
            } else { // 합이 양수인 경우
                r--;
            }
        }

        System.out.println(answerL + " " + answerR);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}