import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair3 {
    int p, t;
    public Pair3(int p, int t) {
        this.p = p;
        this.t = t;
    }
}

public class BOJ1697 {
    int N = 0, K = 0, time = 0;
    Queue<Pair3> q = new LinkedList<>();
    int[] isVisited = new int[100001];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈 위치 (시작점) - 0
        K = Integer.parseInt(st.nextToken()); // 동생 위치 - 3

        Arrays.fill(isVisited, -1);

        q.add(new Pair3(N, 0)); // (0, 0)
        while (!q.isEmpty()) {
            Pair3 curr = q.remove(); // (0, 0)

            if (isVisited[curr.p] == 1) {
                continue;
            }
            if (curr.p == K) {
                time = curr.t;
                break;
            }
            isVisited[curr.p] = 1;

            int nextPlus = curr.p + 1; // 1
            int nextMinus = curr.p - 1; // -1
            int nextMul = curr.p * 2; // 0

            if (nextPlus <= 100000) {
                Pair3 currPlus = new Pair3(nextPlus, curr.t + 1);
                q.add(currPlus);
            }
            if (nextMinus >= 0) {
                Pair3 currMinus = new Pair3(nextMinus, curr.t + 1);
                q.add(currMinus);

            }
            if (nextMul <= 100000) {
                Pair3 currMultiply = new Pair3(nextMul, curr.t + 1);
                q.add(currMultiply);
            }
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1697().solution();
    }
}