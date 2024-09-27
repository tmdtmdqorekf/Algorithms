import java.io.*;
import java.util.*;

public class Main {
    int N, K;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 사진틀 만들기 (큐)
        Queue<Integer> q = new LinkedList<>();

        // 투표현황 해시맵 만들기 (후보별 투표 수 관리)
        HashMap<Integer, Integer> map = new HashMap<>();

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int vote = Integer.parseInt(st.nextToken());

            // 이미 사진틀에 있는 경우: 투표 수만 증가
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
            } else {
                // 사진틀이 꽉 찬 경우 (큐의 크기가 N일 때)
                if (q.size() == N) {
                    // 투표 수가 가장 적은 후보 찾기
                    int minVotes = Collections.min(map.values());

                    // 가장 적은 투표수를 가진 후보 중 가장 오래된 후보를 제거
                    for (int candidate : q) {
                        if (map.get(candidate) == minVotes) {
                            q.remove(candidate);
                            map.remove(candidate); // 해시맵에서도 제거
                            break;
                        }
                    }
                }

                // 새로운 후보 추가
                q.add(vote);
                map.put(vote, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(q);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
