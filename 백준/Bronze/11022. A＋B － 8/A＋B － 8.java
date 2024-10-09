import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = A + B;
            System.out.println("Case #" + i + ": " + A + " + " + B + " = " + C);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
