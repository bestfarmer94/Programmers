package src.level2;

import java.util.ArrayList;

public class 피보나치_수 {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList();
        numbers.add(0);
        numbers.add(1);
        int i = 2;

        while(true){
            int last_1 = numbers.get(numbers.size()-2);
            int last = numbers.get(numbers.size()-1);
            int next = (last + last_1) % 1234567;

            if(i == n){
                answer = next;
                break;
            }

            numbers.add(next);
            i++;
        }

        return answer;
    }
}
