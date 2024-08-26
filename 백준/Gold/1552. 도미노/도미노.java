import java.io.*;
import java.util.*;

/*
1. 같은 행 + 열에서 고르지 않음

2. 사이클 -> A의 두번째 숫자 == B의 첫번재 숫자
(1,3), (3,2)
(1,1) -> 자기 자신도 하나의 그룹

-> 사이클 그룹이 짝수면 -1 곱하기

'얻을 수 있는 최대 점수와 최소 점수는?'
*/

public class Main {
    int[][] map;
    int N;
    int maxScore = Integer.MIN_VALUE;
    int minScore = Integer.MAX_VALUE;

    private void calculate(int[] perm) {
        boolean[] isVisited = new boolean[N];
        int score = 1;
        int groups = 0;

        for (int i = 0; i < N; i++ ) {
            if (!isVisited[i]) {
                groups++;
                int curr = i;
                while (!isVisited[curr]) {
                    isVisited[curr] = true;
                    score *= map[curr][perm[curr]];
                    curr = perm[curr];
                }
            }
        }

        if (groups % 2 == 0) {
            score *= -1;
        }

        maxScore = Math.max(maxScore, score);
        minScore = Math.min(minScore, score);
    }

    private void swap(int[] perm, int i, int j) {
        int tmp = perm[i];
        perm[i] = perm[j];
        perm[j] = tmp;
    }

    private void permutation(int[] perm, int idx) {
        if (idx == N) {
            calculate(perm);
            return;
        }

        for (int i = idx; i < N; i++) {
            swap(perm, idx, i);
            permutation(perm, idx + 1);
            swap(perm, idx, i);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (Character.isLetter(c)) {
                    map[i][j] = -(c - 'A' + 1);
                } else {
                    map[i][j] = Integer.parseInt(String.valueOf(c));
                }
            }
        }
        
        int[] perm = new int[N];
        for (int i = 0; i < N; i++) {
            perm[i] = i;
        }

        permutation(perm, 0);

        System.out.println(minScore);
        System.out.println(maxScore);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}