import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    int val = 1, result = 0;
    Stack<Character> stack = new Stack<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            // 여는 괄호인 경우 push
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                val *= 2;
                continue;
            }
            if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                val *= 3;
                continue;
            }

            // 닫는 괄호인 경우 pop
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (s.charAt(i-1) == '(') {
                    result += val;
                }
                stack.pop();
                val /= 2;
                continue;
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (s.charAt(i-1) == '[') {
                    result += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ2504().solution();
    }
}