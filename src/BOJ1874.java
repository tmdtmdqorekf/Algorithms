import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int start = 0, max = 0;

        Stack<Integer> s = new Stack<>();
        s.push(start);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (s.peek() > num) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            while (s.peek() != num) {
                for (int j = start + 1; j <= num; j++) {
                    s.push(j);
                    max = j;
                    sb.append("+\n");
                }
                start = max;
            }
            s.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
        }

    public static void main(String[] args) throws Exception {
        new BOJ1874().solution();
    }
}
