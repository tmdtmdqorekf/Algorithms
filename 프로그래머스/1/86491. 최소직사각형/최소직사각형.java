import java.util.*;

class Card {
    int x, y;
    
    public Card(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    ArrayList<Card> list = new ArrayList<>();
    
    public int solution(int[][] sizes) {
        // 30, 70 -> 세로가 커서 swap -> 둘다 작음
        // 60, 30 -> 이미 세로가 작음 -> 둘다 작음
        // 60, 50 -> 세로가 커서 swap -> 여전히 세로가 큼, 해당 세로를 new 세로로 갱신
        // 80, 40
        
        for (int[] s : sizes) {
            int x = s[0];
            int y = s[1];
            list.add(new Card(x, y));
        }
        
        list.sort((o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });
        
        Card maxCard = list.get(list.size() - 1);
        int maxX = maxCard.x;
        int maxY = maxCard.y;
        
        System.out.println(maxX + ", " + maxY);
        
        for (int i = 0; i < list.size() - 1; i++) {
            Card currCard = list.get(i);
            
            if (currCard.y > maxX) {
                maxX = currCard.y;
            }
            
            System.out.println("현재: " + currCard.x + ", " + currCard.y);
            
            if (maxY < currCard.x && maxY < currCard.y) {
                maxY = Math.min(currCard.x, currCard.y);
                System.out.println("maxY: " + maxY);
            }
        }
        
        // 12 * 10
        return maxX * maxY;
    }
}