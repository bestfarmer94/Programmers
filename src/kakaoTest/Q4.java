package kakaoTest;

import java.util.ArrayList;

public class Q4 {

	static int result;
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();

		long[] numbers = {63, 111, 95};
		
		sb.append(solution(numbers));
		System.out.println(sb);
	}

	public static ArrayList<Integer> solution(long[] numbers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i<numbers.length; i++) {
        	System.out.println(numbers[i]);
        	result = -1;
        	
        	for(int j=1; j<10; j++) {
        		int digit = (int)Math.pow(2, j) -1;
        		
        		String a = Long.toBinaryString(numbers[i]);
        		if(a.length() > digit) {
        			continue;
        		}
        		
        		if(a.length() < digit) {
        			for(int k=0; k<digit-a.length(); k++) {
        				a = "0" + a;
        			}
        		}
        		
        		confirm(a, j, a.length()/2, 1);
        		break;
        	}
        	
        	answer.add(result);
        }
        
        return answer;
    }
	
	static void confirm(String a, int j, int now, int count) {
		System.out.println(a + " " + j + " " + now + " " + count);
		if(result == 0) {
			return;
		}
		
		if(j == count) {
			if(a.charAt(now) == '1') {
				result = 1;
			}
			return;
		}
		
		if(a.charAt(now) == '1') {
			confirm(a, j, now-(int)Math.pow(2, j-count-1), count+1);
			confirm(a, j, now+(int)Math.pow(2, j-count-1), count+1);
		}else {
			for(int i=now-((int)Math.pow(2, j-count)-1); i<=now+((int)Math.pow(2, j-count)-1); i++) {
				if(a.charAt(i) == '1') {
					result = 0;
				}
			}
		}
	}
}
