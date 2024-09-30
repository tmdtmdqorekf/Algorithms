import java.io.*;
import java.util.*;


public class Main {
    int n, k;

    ArrayList<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        boolean[] isVisited = new boolean[n];

        permutation(k, 0, isVisited);

        System.out.println(set.size());
    }

    private void permutation(int depth, int r, boolean[] isVisited) {
        if (depth == r) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                sb.append(list.get(i));
                isVisited[i] = true;
                permutation(depth, r + 1, isVisited);
                sb.delete(sb.length() - list.get(i).length(), sb.length());
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}