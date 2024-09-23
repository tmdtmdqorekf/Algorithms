import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean[] alphaCheck = new boolean[26];
            boolean isValid = true;
            String str = br.readLine();
            char prev = str.charAt(0);
            alphaCheck[prev - 'a'] = true; // 첫 문자는 바로 체크
            
            for (int j = 1; j < str.length(); j++) {
                char curr = str.charAt(j);

                if (prev != curr) {
                    // 현재 문자가 이전 문자와 다르고, 이미 등장한 적이 있으면 유효하지 않음
                    if (alphaCheck[curr - 'a']) {
                        isValid = false;
                        break;
                    }
                    // 그렇지 않으면 체크하고, 이전 문자를 업데이트
                    alphaCheck[curr - 'a'] = true;
                }
                prev = curr; // 이전 문자 갱신
            }

            if (isValid) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
