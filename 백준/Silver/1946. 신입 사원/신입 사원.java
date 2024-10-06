import java.io.*;
import java.util.*;

class Grade {
    int paper, interview;

    public Grade(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            int answer = 1;
            ArrayList<Grade> list = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                list.add(new Grade(paper, interview));
            }

            list.sort(((o1, o2) -> o1.paper - o2.paper));

            Grade first = list.get(0);
            for (int i = 1; i < N; i++) {
                Grade next = list.get(i);
                if (first.interview > next.interview) {
                    answer++;
                    first = next;
                }
            }

            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}