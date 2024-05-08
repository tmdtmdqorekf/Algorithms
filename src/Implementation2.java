// 왕실의 나이트

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나의 코드
//public class Implementation2 {
//    int result = 0;
//
//    // 동 북 서 남
//    // 2칸 이동
//    int[] dx2 = {2, 0, -2, 0};
//    int[] dy2 = {0, -2, 0, 2};
//
//    // 1칸 이동
//    int[] dx1 = {1, 0, -1, 0};
//    int[] dy1 = {0, -1, 0, 1};
//
//    public int solution() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        // 입력값 int로 변환
//        int currX = input.charAt(0) - 'a' + 1;
//        int currY = input.charAt(1) - '0';
//
//        // 나이트 이동 - 첫번째 2칸 & 두번째 1칸
//        for (int i = 0; i < 4; i++) {
//            int nextX = currX + dx2[i];
//            int nextY = currY + dy2[i];
//
//            if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <= 8) {
//                for (int j = 0; j < 4; j++) {
//                    if (i == 0 && j == 2 || i == 0 && j == 0) {
//                        continue;
//                    }
//                    else if (i == 1 && j == 3 || i == 1 && j == 1) {
//                        continue;
//                    }
//                    else if (i == 2 && j == 0 || i == 2 && j == 2) {
//                        continue;
//                    }
//                    else if (i == 3 && j == 1 || i == 3 && j == 3) {
//                        continue;
//                    }
//
//                    int nextX2 = nextX + dx1[j];
//                    int nextY2 = nextY + dy1[j];
//
//                    if (nextX2 >= 1 && nextX2 <= 8 && nextY2 >= 1 && nextY2 <= 8) {
//                        result += 1;
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//        return result;
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Implementation2().solution();
//    }
//}

// 나동빈님 코드
public class Implementation2 {
    int result = 0;

    // 나이트가 이동할 수 있는 8가지 방향 정의
    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 입력값 int로 변환
        int currX = input.charAt(0) - 'a' + 1;
        int currY = input.charAt(1) - '0';

        // 나이트 이동 - 첫번째 2칸 & 두번째 1칸
        for (int i = 0; i < 8; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <=8) {
                result += 1;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Implementation2().solution();
    }
}

/*

1. L자 형태로만 이동 가능
- 수평 2칸, 수직 1칸
- 수직 2칸, 수평 1칸

2. 범위 밖 x

 */