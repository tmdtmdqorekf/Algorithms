import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int total = 0;

        String tree;
        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            total++; // 전체 종 계산
            map.put(tree, map.getOrDefault(tree, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            list.add(k);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String t : list) {
            double percentage = (double) map.get(t) * 100 / total;
            sb.append(t).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}