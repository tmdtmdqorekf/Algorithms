import java.util.*;

class Mineral {
    int dCnt, iCnt, sCnt;
    
    public Mineral(int dCnt, int iCnt, int sCnt) {
        this.dCnt = dCnt;
        this.iCnt = iCnt;
        this.sCnt = sCnt;
    }
}

class Solution {
    ArrayList<Mineral> list = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 1. 곡괭이로 캘 수 있는 총 광석 수 계산
        int total = 0;
        for (int p : picks) {
            total += p;
        }
        
        // 배열을 잘라서 불필요한 연산 줄이기
        int maxMining = Math.min(minerals.length, total * 5); // 8, 30
        minerals = Arrays.copyOfRange(minerals, 0, maxMining);
        
        // 2. 광석 묶음을 만든다. (5개씩 묶음)
        int dCnt = 0; int iCnt = 0; int sCnt = 0;
        for (int i = 0; i < minerals.length; i += 5) {
            int end = Math.min(i + 5, minerals.length);
            for (int j = i; j < end; j++) {
                if (minerals[j].equals("diamond")) {
                    dCnt++;
                } else if (minerals[j].equals("iron")) {
                    iCnt++;
                } else if (minerals[j].equals("stone")) {
                    sCnt++;
                }
            }
            list.add(new Mineral(dCnt, iCnt, sCnt));
            dCnt = 0; iCnt = 0; sCnt = 0;
        }
        
        // 3. 광석 묶음을 우선순위에 따라 정렬 (다이아가 많은 순, 다이아가 같으면 철 많은 순)
        list.sort((o1, o2) -> {
            if (o1.dCnt == o2.dCnt) {
                return o2.iCnt - o1.iCnt;
            }
            return o2.dCnt - o1.dCnt;
        });
        
        // 4. 각 묶음을 처리할 때 곡괭이 우선순위를 고려하여 처리
        int dPick = picks[0];
        int iPick = picks[1];
        int sPick = picks[2];
        
        for (Mineral m : list) {
            // 곡괭이가 없으면 중단
            if (dPick == 0 && iPick == 0 && sPick == 0) {
                break;
            }

            // 다이아 곡괭이가 있으면 먼저 사용
            if (dPick > 0) {
                answer += m.dCnt + m.iCnt + m.sCnt;
                dPick--;
            } 
            // 철 곡괭이
            else if (iPick > 0) {
                answer += (m.dCnt * 5) + m.iCnt + m.sCnt;
                iPick--;
            } 
            // 돌 곡괭이
            else if (sPick > 0) {
                answer += (m.dCnt * 25) + (m.iCnt * 5) + m.sCnt;
                sPick--;
            }
        }
        
        return answer;
    }
}
