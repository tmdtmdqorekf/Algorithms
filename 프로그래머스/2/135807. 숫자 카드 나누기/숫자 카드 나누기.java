import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
 
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if(!isDividable(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        if (!isDividable(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        
        return answer;
    }
 
    // 최대공약수
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    
    private boolean isDividable(int[] array, int gcd){
        for (int n : array) {
            if (n % gcd == 0){
                return true;
            }
        }
        return false;
    }
}