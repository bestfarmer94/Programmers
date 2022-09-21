package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

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
		
		for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                if(n == i*i){
                    answer += i;
                }else{
                    answer += i + n/i;
                }
            }
        }
		
        return answer;
    }
}