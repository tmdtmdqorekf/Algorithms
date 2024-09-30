import java.io.*;
import java.util.*;

public class Main {
    Stack<Character> s = new Stack<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String exp = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));

            // 쌓인 문자열이 폭발 문자열보다 큰 경우에만 체크
            if (s.size() >= exp.length()) {
                boolean isExp = true;

                for (int j = 0; j < exp.length(); j++) {
                    if (s.get(s.size() - exp.length() + j) != exp.charAt(j)) {
                        isExp = false;
                        break;
                    }
                }

                if (isExp) {
                    for (int j = 0; j < exp.length(); j++) {
                        s.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) {
            System.out.print("FRULA");
            return;
        } else {
            for (char x : s) {
                sb.append(x);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
