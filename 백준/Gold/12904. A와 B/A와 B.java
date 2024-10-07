import java.io.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(T); // ABBA

        while (sb.length() > S.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (sb.charAt(sb.length() - 1) == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        if (sb.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}