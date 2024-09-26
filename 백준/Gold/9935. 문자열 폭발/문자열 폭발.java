import java.io.*;
import java.time.chrono.IsoEra;
import java.util.*;

public class Main {
    StringTokenizer st;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String strExp = br.readLine();

        Stack<Character> s = new Stack<>();

        // 1. 문자열을 하나씩 스택에 넣는다.
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));

            // 2. 스택의 크기가 폭발 문자열과 크거나 같으면 비교한다.
            if (s.size() >= strExp.length()) {
                boolean isExp = true;

                for (int j = 0; j < strExp.length(); j++) {
                    if (s.get(s.size() - strExp.length() + j) != strExp.charAt(j)) {
                        isExp = false;
                        break;
                    }
                }

                // 3. 폭발 문자열과 같으면 스택에서 제거한다.
                if (isExp) {
                    for (int j = 0; j < strExp.length(); j++) {
                        s.pop();
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (!s.isEmpty()) {
            for (int i = 0; i < s.size(); i++) {
                sb.append(s.get(i));
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}