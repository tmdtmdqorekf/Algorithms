import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Greedy1 {
//    public int solution() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int result = 0;
//
//        while (true) {
//            if (N < K) {
//                break;
//            }
//            if ((N % K) == 0) {
//                N = N / K;
//                result++;
//            }
//            else {
//                N = N-1;
//                result++;
//            }
//        }
//
//        System.out.println(result);
//        return result;
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Greedy1().solution();
//    }
//}


/*

연산 최솟값

1. N-1
2. if (N//K) == 0 -> N//K

K가 1보다 큰 수인 경우 2번 연산을 하는게 더 효율적
while true:
    if (N/K) == 0
        if (N<K)
            break;
        N = N/K;

    N = N-1;

 */


// 정답
public class Greedy1 {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        while (true) {
            if (N < K) {
                break;
            }
            if ((N % K) == 0) {
                N = N / K;
                result++;
            }
            else {
                N = N-1;
                result++;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Greedy1().solution();
    }
}