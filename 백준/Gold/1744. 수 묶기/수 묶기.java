import java.io.*;
import java.util.*;

public class Main {
    int N, sum;

    ArrayList<Integer> pList = new ArrayList<>();
    ArrayList<Integer> nzList = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 수열이 1인 경우 바로 return
        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n > 0) {
                pList.add(n);
            } else {
                nzList.add(n);
            }
        }

        // 5 4 3 1
        pList.sort(Collections.reverseOrder());

        // -3 -2 -1 0
        Collections.sort(nzList);

        for (int i = 0; i < pList.size(); i = i + 2) {
            if (i == pList.size() - 1) {
                sum += pList.get(i);
                break;
            }
            if (pList.get(i) == 1 || pList.get(i + 1) == 1) {
                sum += pList.get(i) + pList.get(i + 1);
            } else {
                sum += pList.get(i) * pList.get(i + 1);
            }
        }


        for (int i = 0; i < nzList.size(); i = i + 2) {
            if (i == nzList.size() - 1) {
                sum += nzList.get(i);
                break;
            }
            sum += nzList.get(i) * nzList.get(i + 1);
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}