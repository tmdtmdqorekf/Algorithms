import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy2 {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(""); // 02985
        int result = Integer.parseInt(S[0]); // 0

        for (int i = 1; i < S.length; i++) {
            int n = Integer.parseInt(S[i]); // 2, 9

            if (result <= 1 || n <= 1) {
                result += n; // 0 + 2 = 2
            }
            else {
                result *= n; // 2 * 9 = 18
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Greedy2().solution();
    }
}

/*

S = 02985

1. 문자열 띄우기
{0, 2, 9, 8, 5}

2. +가 필요한 경우
0, 1

3. 나머지는 *


 */