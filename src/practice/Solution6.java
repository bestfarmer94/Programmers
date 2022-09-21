package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n));
		System.out.println(sb);
		br.close();
	}
	
	
	public static int solution(int n) {
        int answer = 0;

        while(n != 0) {
        	answer += n % 10;
        	n /= 10;
        }

        return answer;
    }
}