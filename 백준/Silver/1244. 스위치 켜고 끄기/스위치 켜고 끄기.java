import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[] arr;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남학생인 경우
                for (int j = num; j < arr.length; j = j += num) {
                    swap(j);
                }
            } else if (gender == 2) { // 여학생인 경우
                swap(num);

                int l = num - 1;
                int r = num + 1;

                while (l > 0 && r <= N && arr[l] == arr[r]) {
                    swap(l);
                    swap(r);
                    l--;
                    r++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private void swap(int idx) {
        if (arr[idx] == 0) {
            arr[idx] = 1;
        } else {
            arr[idx] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}