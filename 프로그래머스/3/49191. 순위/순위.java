import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // 내가 패배한 선수
        HashMap<Integer, HashSet<Integer>> map1 = new HashMap<>();
        
        // 내가 이긴 선수
        HashMap<Integer, HashSet<Integer>> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map1.put(i, new HashSet<>());
            map2.put(i, new HashSet<>());
        }

        for (int[] result : results) {
            map1.get(result[1]).add(result[0]);
            map2.get(result[0]).add(result[1]);
        }
        
//         for (int i = 1; i <= n; i++) {
//             HashSet<Integer> set = map1.get(i);
            
//             for (int player : set) {
//                 System.out.println(player);
//                 HashSet<Integer> set2 = map1.get(player);
                
//                 for (int p : set2) {
//                     map1.get(i).add(p);
//                 }
//             }
//         }
        
        // 각 선수에 대해 BFS 수행
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = map1.get(i);
            Queue<Integer> queue = new LinkedList<>(set); // 처음 선수들의 집합을 큐에 추가
            
            while (!queue.isEmpty()) {
                int player = queue.poll();
                HashSet<Integer> set2 = map1.get(player);
                
                for (int p : set2) {
                    if (map1.get(i).add(p)) {  // 새로 추가된 선수만 큐에 삽입
                        queue.add(p);
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = map2.get(i);
            Queue<Integer> queue = new LinkedList<>(set); // 처음 선수들의 집합을 큐에 추가
            
            while (!queue.isEmpty()) {
                int player = queue.poll();
                HashSet<Integer> set2 = map2.get(player);
                
                for (int p : set2) {
                    if (map2.get(i).add(p)) {  // 새로 추가된 선수만 큐에 삽입
                        queue.add(p);
                    }
                }
            }
        }
        
        // System.out.println(map1);
        // System.out.println(map2);
        
        for (int i = 1; i <= n; i++) {
            int totalKnownMatches = map1.get(i).size() + map2.get(i).size();  // 내가 이기고 진 선수들의 합
            if (totalKnownMatches == n - 1) {  // 나를 제외한 모든 선수와의 관계가 결정되었을 때
                answer++;
            }
        }
        
        return answer;
    }
}