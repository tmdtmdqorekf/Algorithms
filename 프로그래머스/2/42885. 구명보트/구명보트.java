import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people); // 사람들의 몸무게를 오름차순으로 정렬
        
        int i = 0;
        int j = people.length - 1; // 끝에서부터 가장 무거운 사람을 선택
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 두 사람의 몸무게 합이 limit 이하이면 두 사람을 보트에 태움
                i++;
            }
            // 무거운 사람을 보트에 태우고 인덱스를 줄임
            j--;
            answer++; // 보트 사용 증가
        }
        
        return answer;
    }
}
