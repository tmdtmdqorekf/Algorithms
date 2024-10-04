import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    int N;
    ArrayList<Integer> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 각 로프에는 w/k만큼의 중량이 걸림
        // 만약 22kg 물체가 있으면
        // 22/2 = 11kg의 중량이 걸림
        // 11 > 10(x), 11 < 15(o)

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, list.get(i) * (i+1));
        }

        System.out.println(max);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}