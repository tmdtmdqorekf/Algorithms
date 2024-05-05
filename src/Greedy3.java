import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 나의 코드
//public class Greedy3 {
//    public int solution() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken()); // 2 3 1 2 2
//        }
//        Arrays.sort(arr); // 1 2 2 2 3
//
//        int result = 0;
//
//        // 비교
//        for (int i = 0; i < N-1; i++) {
//            int lv1 = arr[i]; // 1
//            int lv2 = arr[i+1]; // 2
//
//            if (lv1 == 1) {
//                result++;
//            }
//            else if (lv1 == lv2) {
//                result++;
//                i = i + lv2;
//            }
//        }
//
//        System.out.println(result);
//        return result;
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Greedy3().solution();
//    }
//}

// 나동빈님 코드
public class Greedy3 {
    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(st.nextToken())); // 2 3 1 2 2
        }
        Collections.sort(arrayList); // 1 2 2 2 3

        int result = 0; // 총 그룹의 수
        int count = 0; // 현재 그룹에 포함된 모험가의 수

        for (int i = 0; i < N; i++) { // 공포도 낮은 것부터 하나씩 확인하며
            count += 1; // 현재 그룹에 해당 모험가를 포함시키기
            if (count >= arrayList.get(i)) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                result += 1;
                count = 0;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Greedy3().solution();
    }
}

/*

S = 2 3 1 2 2

1. 오름차순 정렬
-> 1 2 2 2 3

2. 최소단위로 그룹화

3. 그룹화되지 못한 애들은 남기기

 */