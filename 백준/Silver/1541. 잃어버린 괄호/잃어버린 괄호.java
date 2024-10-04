import java.io.*;
import java.util.*;

public class Main {
    int sum = 0;
    boolean minus = false;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 괄호를 쳐서 값을 최소로 만들기
        // 10-(20+40+30)
        // -(10+20)-5
        // -(10+20+5)
        // -를 만나면 -를 또 만나기 전까지 -(값)의 sum

        // sb에다 부호 나오기 전까지 저장하고 Integer.parseInt

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == '-' || str.charAt(i) == '+') {
                int n = Integer.parseInt(sb.toString());

                if (minus) {
                    sum -= n;
                } else {
                    sum += n;
                }

                sb.setLength(0);
                if (i < str.length() && str.charAt(i) == '-') {
                    minus = true;
                }
            } else {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sum);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
