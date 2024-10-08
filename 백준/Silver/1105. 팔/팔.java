import java.io.*;
import java.util.*;

public class Main {
    String L, R;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = st.nextToken();
        R = st.nextToken();

        int cnt = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) {
                    break;
                } else {
                    if (L.charAt(i) == '8') {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}