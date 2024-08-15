import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // 내가 패배한 선수
        Map<Integer, HashSet<Integer>> map1 = new HashMap<>();
        
        // 내가 이긴 선수
        Map<Integer, HashSet<Integer>> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map1.put(i, new HashSet<>());
            map2.put(i, new HashSet<>());
        }

        for (int[] result : results) {
            map1.get(result[1]).add(result[0]);
            map2.get(result[0]).add(result[1]);
        }

        dfs(map1, n);
        dfs(map2, n);
        
        for (int i = 1; i <= n; i++) {
            // 내가 패배했거나 이긴 선수들의 합
            int total = map1.get(i).size() + map2.get(i).size();
            if (total == n-1) { // 나를 제외한 모든 선수와의 관계가 결정된 경우
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(Map<Integer, HashSet<Integer>> map, int n) {
        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new LinkedList<>(map.get(i)); // 처음 선수들의 집합을 큐에 추가
            
            while (!q.isEmpty()) {
                int player = q.poll();
                HashSet<Integer> set = map.get(player);
                for (int s : set) {
                    if (map.get(i).add(s)) { // 새로 추가된 선수만 큐에 삽입
                        q.add(s);
                    }
                }
            }
        }
    }
}