import java.io.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] charArr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean isTag = false;

        for (char c : charArr) {
            if (c == '<') {
                sb2.append(sb.reverse()).append(c);
                sb.setLength(0);
                isTag = true;
            } else if (c == '>') {
                isTag = false;
                sb2.append(sb).append(c);
                sb.setLength(0);
            } else if (isTag) {
                sb2.append(c);
            } else {
                if (c == ' ') {
                    sb2.append(sb.reverse()).append(" ");
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }

        sb2.append(sb.reverse());

        System.out.println(sb2);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}