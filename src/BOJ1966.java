//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ1966 {
//    int cnt;
//
//    public void solution() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int k = Integer.parseInt(br.readLine());
//        for (int i = 0; i < k; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//            int N = Integer.parseInt(st.nextToken()); // 문서 개수
//            int M = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서
//
//            String[] priority = br.readLine().split(" ");
//
//            Queue<int[]> q = new LinkedList<>();
//            for (int j = 0; j < N; j++) {
//                q.add(new int[] {j, Integer.parseInt(priority[j])});
//            }
//
//            while (!q.isEmpty()) {
//                int max = Collections.max(q);
//
//                int max = arr[]
//            }
//
//
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        new BOJ1966().solution();
//    }
//}
