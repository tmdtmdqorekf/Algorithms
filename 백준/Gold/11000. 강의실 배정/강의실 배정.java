import java.io.*;
import java.util.*;

class Class {
    int start, end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    int N;
    int answer = 1;

    ArrayList<Class> list = new ArrayList<>();

    PriorityQueue<Class> pq = new PriorityQueue<>(new Comparator<Class>() {
        @Override
        public int compare(Class o1, Class o2) {
            return o1.end - o2.end;
        }
    });

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            list.add(new Class(S, T));
        }

        list.sort((o1, o2) -> o1.start - o2.start);

        pq.add(list.get(0));

        for (int i = 1; i < N; i++) {
            if (pq.peek().end <= list.get(i).start) {
                pq.poll();
            } else {
                answer++;
            }

            pq.add(list.get(i));
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}