import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11399 {
    int num = 0, result = 0;
    ArrayList<Integer> arr = new ArrayList<>();

    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr); // 1 2 3 3 4

        for (int i = 0; i < N; i++) {
            num += arr.get(i);
            result += num;
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new BOJ11399().solution();
    }
}