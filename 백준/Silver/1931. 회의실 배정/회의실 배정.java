import java.io.*;
import java.util.*;

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    int N;
    int maxMeetings = 1;

    ArrayList<Meeting> list = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        list.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        Meeting m = list.get(0); // (1, 1)
        for (int i = 1; i < N; i++) {
            Meeting nm = list.get(i); // (1, 1)
            if (m.end > nm.start) {
                continue;
            }
            m = nm;
            maxMeetings++;
        }

        System.out.println(maxMeetings);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}