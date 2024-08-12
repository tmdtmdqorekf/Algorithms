class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) { // 제일 왼쪽 줄
                    triangle[i][j] += triangle[i-1][j];
                }
                else if (i == j) { // 제일 오른쪽 줄
                    triangle[i][j] += triangle[i-1][j-1];
                } else { // 중간 줄들
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                
                answer = Math.max(answer, triangle[i][j]);
            }
        }
    
        return answer;
    }
}