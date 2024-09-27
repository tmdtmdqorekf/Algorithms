import java.io.*;
import java.util.*;

public class Main {
    int n, k;
    StringBuilder sb = new StringBuilder();
    Set<String> answer = new HashSet<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < k; i++) {
            permutation(list, isVisited,0);
        }

        System.out.println(answer.size());
    }

    private void permutation(ArrayList<String> list, boolean[] isVisited, int depth) {
        if (depth == k) {
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(list.get(i));
                permutation(list, isVisited,depth + 1);
                sb.delete(sb.length() - list.get(i).length(), sb.length());
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}