import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int cnt = 1;

            for (int j = i; j < s.length(); j += i) {
                String curr;
                if (j + i <= s.length()) {
                    curr = s.substring(j, j + i);
                } else {
                    curr = s.substring(j);
                }

                if (prev.equals(curr)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt).append(prev);
                    } else {
                        sb.append(prev);
                    }
                    prev = curr;
                    cnt = 1;
                }
            }

            if (cnt > 1) {
                sb.append(cnt).append(prev);
            } else {
                sb.append(prev);
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
