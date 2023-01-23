package src.level2;

// 비트로 변환한 후 1의 갯수를 세주는 함수.
// 비트 관련이라 쓸 일이 있을지 모르겠다.
// 일단은 메모.

public class 다음_큰_숫자_Integer_bitCount {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while(Integer.bitCount(++n) != cnt) {}
        return n;
    }
}
