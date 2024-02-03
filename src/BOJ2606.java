import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    int[] arr;
    int a, b, cnt;

    public int find(int r) {
        if (r == arr[r]) {
            return r;
        }

        return arr[r] = find(arr[r]);
    }

    public void union(int a, int b) {
        int u = find(a);
        int v = find(b);

        if (u == v) {
            return;
        }

        // 더 작은 값이 root 가 되도록 설정
        if (u < v) {
            arr[v] = u;
        }
        else {
            arr[u] = v;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int E = Integer.parseInt(br.readLine());
        for (int i = 1; i <= E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 2; i <= N; i++) {
            if (find(i) == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new BOJ2606().solution();
    }
}
