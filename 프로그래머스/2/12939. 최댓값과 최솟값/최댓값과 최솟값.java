import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s, " ");
        
        int cnt = st.countTokens();
        
        int[] arr = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        String min = Integer.toString(arr[0]);
        String max = Integer.toString(arr[cnt-1]);
        
        answer = min + " " + max;
        
        return answer;
    }
}