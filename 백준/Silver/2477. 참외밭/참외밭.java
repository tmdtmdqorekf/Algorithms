import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    int K;
    int[] len;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        int maxH = Integer.MIN_VALUE;
        int maxW = Integer.MIN_VALUE;

        int idxH = 0;
        int idxW = 0;

        len = new int[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if (dir == 1 || dir == 2) {
                if (maxW < len[i]) {
                    maxW = len[i];
                    idxW = i;
                }
            } else {
                if (maxH < len[i]) {
                    maxH = len[i];
                    idxH = i;
                }
            }
        }

        int smallW = calculate(idxH);
        int smallH = calculate(idxW);

        int answer = ((maxH * maxW) - (smallH * smallW)) * K;

        System.out.println(answer);
    }

    private int calculate(int idx) {
        int length = 0;

        if (idx == 0) {
            length = Math.abs(len[idx+1] - len[5]);
        } else if (idx == 5) {
            length = Math.abs(len[idx-1] - len[0]);
        } else {
            length = Math.abs(len[idx+1] - len[idx-1]);
        }

        return length;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}