// 문자의 재정렬

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Implementation3 {
    ArrayList<Character> result = new ArrayList<>();
    int value = 0;

    public ArrayList<Character> solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // K1KA5CB7

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                result.add(input.charAt(i));
            }
            else {
                value += input.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        for (Character s : result) {
            System.out.print(s);
        }

        if (value != 0) {
            System.out.print(value);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        new Implementation3().solution();
    }
}