import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀함수 사용과 union 함수 구현이 어려음

public class BOJ1717 {
    static int[] parent;

    public void setParent(int n) {
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // b의 부모를 a의 부모로 치환
    public void union(int a, int b) {
        int u = findParent(a);
        int v = findParent(b);

        if (u != v) {
            if (u < v) {
                parent[v] = u;
            }
            else {
                parent[u] = v;
            }
        }
    }

    public int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public boolean hasSameParent(int a, int b) {
        int u = findParent(a);
        int v = findParent(b);

        return (u == v);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setParent(n);

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int unionOrAsk = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            StringBuilder sb = new StringBuilder();

            // union
            if (unionOrAsk == 0) {
                union(a, b);
            }
            // find
            else if (unionOrAsk == 1) {
                sb.append(hasSameParent(a, b) ? "YES" : "NO");
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ1717().solution();
    }
}
