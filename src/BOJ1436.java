import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1436 {
    int cnt = 0;
    String ans;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 666; ; i++) {
            if (cnt == N) {
                break;
            }
            if (String.valueOf(i).contains("666")) {
                cnt++;
                ans = String.valueOf(i);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1436().solution();
    }
}
