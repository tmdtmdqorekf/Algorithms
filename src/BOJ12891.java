//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    String[] arr;
//    int A, C, G, T;
//    int cnt = 0;
//
//    public void solution() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int S = Integer.parseInt(st.nextToken());
//        int P = Integer.parseInt(st.nextToken());
//
//        arr = new String[S];
//        arr = br.readLine().split("");
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        A = Integer.parseInt(st2.nextToken());
//        C = Integer.parseInt(st2.nextToken());
//        G = Integer.parseInt(st2.nextToken());
//        T = Integer.parseInt(st2.nextToken());
//
//        for (int i = 0; i < (S / P) * P; i++) {
//            int Acnt = 0, Ccnt = 0, Gcnt = 0, Tcnt = 0;
//            for (int j = i; j < i + P; j++) {
//                if (j == S) {
//                    break;
//                }
//                if (arr[j].equals("A")) {
//                    Acnt++;
//                }
//                else if (arr[j].equals("C")) {
//                    Ccnt++;
//                }
//                else if (arr[j].equals("G")) {
//                    Gcnt++;
//                }
//                else if (arr[j].equals("T")) {
//                    Tcnt++;
//                }
//            }
//            if (Acnt >= A && Ccnt >= C && Gcnt >= G && Tcnt >= T) {
//                cnt++;
//            }
//        }
//
//        System.out.println(cnt);
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
    char[] arr;
    int[] cntArr, cntArr2;
    int cnt = 0;

    public void add(char x) {
        switch (x) {
            case 'A':
                cntArr2[0]++;
                break;
            case 'C':
                cntArr2[1]++;
                break;
            case 'G':
                cntArr2[2]++;
                break;
            case 'T':
                cntArr2[3]++;
                break;
        }
    }

    public void remove(char x) {
        switch (x) {
            case 'A':
                cntArr2[0]--;
                break;
            case 'C':
                cntArr2[1]--;
                break;
            case 'G':
                cntArr2[2]--;
                break;
            case 'T':
                cntArr2[3]--;
                break;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();

        // A C G T
        cntArr = new int[4];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cntArr[i] = Integer.parseInt(st2.nextToken());
        }

        // 초기 윈도우 설정
        cntArr2 = new int[4];
        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        if (cntArr2[0] >= cntArr[0] && cntArr2[1] >= cntArr[1] && cntArr2[2] >= cntArr[2] && cntArr2[3] >= cntArr[3]) {
            cnt++;
        }

        for (int j = P; j < S; j++) {
            int i = j-P;
            add(arr[j]);
            remove(arr[i]);

            if (cntArr2[0] >= cntArr[0] && cntArr2[1] >= cntArr[1] && cntArr2[2] >= cntArr[2] && cntArr2[3] >= cntArr[3]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new BOJ12891().solution();
    }
}
