import java.io.*;
import java.util.*;

public class Main {
    int g = 0;
    ArrayList<Integer> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1개인 경우 고려
        if (n == 1) {
            System.out.println(st.nextToken());
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        int x = list.get(0); // 40
        for (int i = 0; i < n - 1; i++) {
            int y = list.get(i + 1); // 30

            g += (x + y);
        }

        System.out.println(g);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}