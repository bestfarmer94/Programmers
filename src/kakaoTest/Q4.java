package kakaoTest;

import java.util.ArrayList;

public class Q4 {

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
        	long number = 8;
        	int count = 2;
        	int digit = 3;
        	int result = 1;
        	
        	
        	for(int j=0; j<5; j++) {
        		if(j>0) {
        			count *= 2;
            		number *= Math.pow(2, count);
            		digit += count;
        		}
        		
        		if(numbers[i] < number) {
        			String a = Long.toBinaryString(numbers[i]);
        			System.out.println(a);
        			if(a.length() == digit || a.length() == digit -1) {
        				int count2 = 0;
        				for(int k=0; k<a.length(); k++) {
        					if(a.length()%2 == 0) {
        						if(k%2 == 0) {
            						if(a.charAt(k) == '0') {
            							
            							result = 0;
            							break;
            						}
            					}else {
            						if(a.charAt(k) == '1') {
            							count2++;
            						}
            					}
        					}else {
        						if(k%2 == 1) {
            						if(a.charAt(k) == '0') {
            							
            							result = 0;
            							break;
            						}
            					}else {
            						if(a.charAt(k) == '1') {
            							count2++;
            						}
            					}
        					}
        				}
        				
        				if(count2 == 0) {
        					result = 0;
        				}
        			}else {
        				result = 0;
        			}
        			break;
        		}
        	}
        	
        	answer.add(result);
        }
        
        return answer;
    }
}
