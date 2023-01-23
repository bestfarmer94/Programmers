package src.level2;

import java.util.Arrays;
import java.util.Collections;

class 최솟값_만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);

        Integer[] B_clone = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            B_clone[i] = B[i];
        }

        Arrays.sort(B_clone, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B_clone[i];
        }

        return answer;
    }
}
