import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    String[][] arr;
    int minVal = 64;

    String[][] wStart = {
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"}
    };
    String[][] bStart = {
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"},
            {"B", "W", "B", "W", "B", "W", "B", "W"},
            {"W", "B", "W", "B", "W", "B", "W", "B"}
    };

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.split("")[j];
            }
        }

        // 오른쪽/아래로 옮기는 횟수
        for (int i = 0; i < (N - 7); i++) {
            for (int j = 0; j < (M - 7); j++) {
                int cntW = 0;
                int cntB = 0;
                // 그 안에서 비교
                for (int k = i; k < (8 + i); k++) {
                    for (int l = j; l < (8 + j); l++) {
                        // W로 시작하는 경우
                        if (!wStart[k-i][l-j].equals(arr[k][l])) {
                            cntW++;
                        }
                        // B로 시작하는 경우
                        if (!bStart[k-i][l-j].equals(arr[k][l])) {
                            cntB++;
                        }
                    }
                }
                minVal = Math.min(minVal, Math.min(cntW, cntB));
            }
        }

        System.out.println(minVal);
    }

    public static void main(String[] args) throws Exception {
        new BOJ1018().solution();
    }
}
