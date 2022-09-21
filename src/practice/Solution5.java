package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n));
		System.out.println(sb);
		br.close();
	}
	
	
	public static long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        
        if(n == sqrt*sqrt) {
        	answer = (long)((sqrt+1)*(sqrt+1));	// answer = (long) math.pow(sqrt+1, 2);
        }else {
        	answer = -1;
        }
        
        return answer;
    }
}