package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		sb.append(solution(n,k));
		System.out.println(sb);
		br.close();
	}

	public static int solution(int n, int k) {
        int answer = 0;
        
        String a = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(a, "0");
        
//        String[] b = Integer.toString(n, k).split("0");
        
        while(st.hasMoreTokens()) {
        	long number = Long.parseLong(st.nextToken());
        	
        	for(int i=2; i<=Math.sqrt(number); i++) {
        		if(number%i == 0) {
        			number = 1;
        			break;
        		}
        	}
        	
        	if(number != 1) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
}
