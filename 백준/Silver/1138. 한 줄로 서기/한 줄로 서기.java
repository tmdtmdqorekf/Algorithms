import java.io.*;
import java.util.*;


public class Main {
    int N;
    int[] higherCnt;
    ArrayList<Integer> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        higherCnt = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            higherCnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            list.add(higherCnt[i], i);
        }

        for (int n : list) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}