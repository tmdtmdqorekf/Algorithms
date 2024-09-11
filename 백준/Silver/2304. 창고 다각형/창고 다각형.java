import java.io.*;
import java.util.*;

public class Main {
    StringTokenizer st;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr[L] = H; // 해당 좌표에 높이 저장
            start = Math.min(L, start); // 2
            end = Math.max(L, end); // 15
        }

        Stack<Integer> s = new Stack<>();

        // 좌 -> 우
        int tmpH = arr[start]; // 4
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < tmpH) { // 현재 높이가 이전 높이보다 작은 경우
                s.push(i);
            } else { // 현재 높이가 이전 높이보다 클 경우
                while (!s.isEmpty()) {
                    int tmpL = s.pop();
                    arr[tmpL] = tmpH; // 스택에서 꺼낸 좌표의 높이를 이전 높이로 채움
                }
                tmpH = arr[i];
            }
        }
        s.clear();

        // 우 -> 좌
        tmpH = arr[end]; // 15
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < tmpH) { // 현재 높이보다 작은 경우
                s.push(i);
            } else { // 현재 높이보다 큰 경우
                while (!s.isEmpty()) {
                    int tmpL = s.pop();
                    arr[tmpL] = tmpH;
                }
                tmpH = arr[i];
            }
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += arr[i]; // 면적 계산
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}