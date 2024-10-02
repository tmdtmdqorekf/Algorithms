import java.util.*;

class Solution {
    ArrayList<String> answer = new ArrayList<>();
    boolean[] isVisited;

    public String[] solution(String[][] tickets) {
        isVisited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    public void dfs(int r, String now, String path, String[][] tickets){
        if (r == tickets.length) {
            answer.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && now.equals(tickets[i][0])) {
                isVisited[i] = true;
                dfs(r + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                isVisited[i] = false;
            }
        }
    }
}