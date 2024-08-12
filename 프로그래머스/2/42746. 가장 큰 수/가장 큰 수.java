import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // String으로 변환
        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add(Integer.toString(n));
        }
        
        // 이어붙인 String의 크기를 비교 및 정렬
        list.sort((a, b) -> (b + a).compareTo(a + b));
        
        // 앞자리가 0이면 숫자를 만들 수 없으니 예외처리
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        // 가장 큰 숫자 출력
        StringBuilder sb = new StringBuilder();
        for (String num : list) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}
