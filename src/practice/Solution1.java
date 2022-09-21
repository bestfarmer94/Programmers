package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n));
		System.out.println(sb);
		br.close();
	}
	
	
    public static String solution(int num) {
        
        String answer = "";
       
        if(Math.abs(num)%2 == 0) {
        	answer = "Even";
        }else {
        	answer = "Odd";
        }
        
        return answer;
    }

}
