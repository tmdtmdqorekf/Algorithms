class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];

        // 마지막 줄을 초기화
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            dp[i] = triangle[triangle.length - 1][i];
        }

        // 아래에서 위로 삼각형 탐색
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[j] = triangle[i][j] + Math.max(dp[j], dp[j + 1]);
            }
        }

        return dp[0]; // 최상단에 저장된 최대 합 반환
    }
}
