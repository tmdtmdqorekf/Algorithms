import java.io.*;
import java.util.*;

public class Main {
    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> B = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);
        B.sort((o1, o2) -> o2 - o1);

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += A.get(i) * B.get(i);
        }

        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
