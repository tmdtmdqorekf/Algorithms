import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long maxTotal = 0;

            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int max = 0;

            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j) > max) {
                    max = list.get(j);
                } else {
                    maxTotal += max - list.get(j);
                }
            }

            System.out.println(maxTotal);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}