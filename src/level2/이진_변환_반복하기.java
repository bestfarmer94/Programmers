package src.level2;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        return binary(s, answer);
    }

    int[] binary(String str, int[] arr) {
        arr[0]++;

        String new_str = str.replaceAll("0", "");
        arr[1] += str.length() - new_str.length();

        int length = new_str.length();
        String binary_str = Integer.toBinaryString(length);

        if(new_str.equals("1")){
            return arr;
        }
        return binary(binary_str, arr);
    }
}
