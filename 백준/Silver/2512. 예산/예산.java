import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;
    List<Integer> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort((o1, o2) -> o1 - o2);

        int total = Integer.parseInt(br.readLine());

        int l = 1;
        int r = list.get(N - 1); // 100
        int mid = 0;

        int answer = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = list.get(i);
                if (num > mid) { // 값이 mid보다 더 크면
                    sum += mid;
                } else {
                    sum += num;
                }
            }

            if (sum > total) {
                r = mid - 1;
            } else {
                l = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}