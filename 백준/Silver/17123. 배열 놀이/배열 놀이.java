import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열 크기
            int M = Integer.parseInt(st.nextToken()); // 연산 횟수

            int[][] arr = new int[N+1][N+1]; // 실제 배열
            int[][] diff = new int[N+2][N+2]; // 차이 배열 (1-based index, +2로 확장)

            // 초기 배열 입력
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // M개의 연산 적용 (차이 배열에 기록)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 차이 배열에 기록 (구간 업데이트)
                diff[r1][c1] += v;
                diff[r1][c2+1] -= v;
                diff[r2+1][c1] -= v;
                diff[r2+1][c2+1] += v;
            }

            // 차이 배열을 실제 배열에 반영 (2D 누적합 계산)
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    diff[i][j] += diff[i-1][j] + diff[i][j-1] - diff[i-1][j-1]; // 차이값 반영
                    arr[i][j] += diff[i][j]; // 차이 배열의 결과를 실제 배열에 더함
                }
            }

            // 각 행의 합 계산
            StringBuilder sbR = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    sum += arr[i][j];
                }
                sbR.append(sum).append(" ");
            }

            // 각 열의 합 계산
            StringBuilder sbC = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    sum += arr[j][i];
                }
                sbC.append(sum).append(" ");
            }

            System.out.println(sbR);
            System.out.println(sbC);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
