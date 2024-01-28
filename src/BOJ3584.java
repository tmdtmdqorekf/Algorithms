import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// isVisited 개념과 findCommonAncestor 함수 어려움

public class BOJ3584 {
    int[] tree;
    boolean[] isVisited;

    public void setParent(int A, int B) {
        tree[B] = A;
    }
    public void findCommonAncestor(int a, int b) {
        while (a > 0) {
            isVisited[a] = true;
            a = tree[a];
        }

        while (b > 0) {
            if (isVisited[b]) {
                System.out.println(b);
                break;
            }
            b = tree[b];
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            tree = new int[N+1];
            isVisited = new boolean[N+1];

            for (int j = 0; j < N-1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                setParent(A, B);
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            findCommonAncestor(a, b);
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ3584().solution();
    }
}
