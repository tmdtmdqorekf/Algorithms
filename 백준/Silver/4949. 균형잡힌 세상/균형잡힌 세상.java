import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    s.push(c);
                }
                else if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        isBalanced = false;
                        break;
                    } else {
                        s.pop();
                    }
                }
                else if (c == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        isBalanced = false;
                        break;
                    } else {
                        s.pop();
                    }
                }
            }

            if (isBalanced && s.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}