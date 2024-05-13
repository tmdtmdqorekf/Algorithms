import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    int result = 0;
    Stack<Character> stack = new Stack<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (s.charAt(i-1) == '(') { // 레이저인 경우
                    stack.pop(); // 앞에서 막대라고 착각하고 stack에 s[i]를 넣었으므로 pop
                    result += stack.size(); // 막대의 개수만큼 추가
                }
                else { // 레이저가 아닌 막대의 끝인 경우
                    stack.pop(); // 막대의 개수를 1 감소
                    result += 1; // 막대 1개가 절단된 것과 동일한 상황이므로 1 추가
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BOJ10799().solution();
    }
}