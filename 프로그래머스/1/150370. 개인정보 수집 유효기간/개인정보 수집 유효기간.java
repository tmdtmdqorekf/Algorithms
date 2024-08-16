import java.io.*;
import java.util.*;

class Solution {
    StringTokenizer st;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // String -> int
        st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken()) - 2000; // 20
        int month = Integer.parseInt(st.nextToken()); // 1
        int days = Integer.parseInt(st.nextToken()); // 1

        // 오늘 날짜 days로 변환하기
        int todayTotal = (336 * (year + 1)) + (28 * month) + days;
        // System.out.println("todayTotal: " + todayTotal); // 7085
        
        // terms에 따른 유효기간 days로 변환하여 저장
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            st = new StringTokenizer(term, " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], ".");
            int year2 = Integer.parseInt(st.nextToken()) - 2000; // 19
            int month2 = Integer.parseInt(st.nextToken()); // 8
            
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), " ");
            int days2 = Integer.parseInt(st2.nextToken()); // 2
            
            int privacyTotal = (336 * (year2 + 1)) + (28 * month2) + days2;
            
            String term = st2.nextToken();
            
            int expireDays = map.get(term);
            // System.out.println("유효기간: " + expireDays);
            
            if ((privacyTotal + expireDays) <= todayTotal) {
                list.add(i + 1);
                System.out.println("파기번호: " + (i+1));
            }
            
//             System.out.println("번호 " + (i+1) + ": privacyTotal for term " + term + ": " + (privacyTotal + expireDays));
//             System.out.println();
            
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}