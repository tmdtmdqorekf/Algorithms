// class Solution {
//     public int[] solution(int n, long left, long right) {
//         // 1. 2차원 배열 만들기
//         int[][] map = new int[n+1][n+1];
        
//         // 2. i행 i열까지 i로 채우기
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (j <= i) {
//                     map[i][j] = i;
//                 } else {
//                     map[i][j] = j;
//                 }
//             }
//         }
        
//         // 3. 이어붙인 1차원 배열 만들기
//         int[] arr = new int[n*n];

//         int x = 1, j = 1;
//         for (int i = 0; i < n*n; i++) {
//             arr[i] = map[x][j];
//             j++;
            
//             if (j == n + 1) {
//                 j = 1;
//                 x++;
//             }
//         }
        
//         // 4. arr[left] ~ arr[right] 까지만 남기기
//         int[] answer = new int[(int)(right-left+1)];
        
//         int k = 0;
//         for (long i = left; i <= right; i++) {
//             answer[k] = arr[(int)i];
//             k++;
//         }
        
//         return answer ;
//     }
// }

import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        
        List<Long> answer = new ArrayList<>();
        
        for (long i = left; i < right + 1; i++){
             answer.add(Math.max(i/n, i%n) + 1);
        }
        
        return answer;
    }
}