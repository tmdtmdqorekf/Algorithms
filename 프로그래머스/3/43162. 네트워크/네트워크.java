class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(n, computers, i, isVisited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int n, int[][] computers, int i, boolean[] isVisited) {
        isVisited[i] = true;
        
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !isVisited[j]) {
                dfs(n, computers, j, isVisited);
            }
        }
    }
}