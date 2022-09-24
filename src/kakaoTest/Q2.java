package kakaoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cap = 4;
		int n = 5;
		int[] deliveries = {1, 0, 3, 1, 2};
		int[] pickups = {0, 3, 0, 4, 0};
		
		sb.append(solution(cap, n, deliveries, pickups));
		System.out.println(sb);
		br.close();
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n; j++) {
        		deliveries[i] += deliveries[j];
        		pickups[i] += pickups[j];
        	}
        }
        
        int remain = n-1;
        int count = 0;
        while(deliveries[0] > 0 || pickups[0] > 0) {
        	
        	for(int i=remain; i>=0; i--) {
        		if(deliveries[i] > 0 || pickups[i] > 0) {
        			count = Math.max((int)Math.ceil((double)deliveries[i] / cap), (int)Math.ceil((double)pickups[i] / cap));
        			answer += 2*(i+1) * count;
        			remain = i;
        			break;
        		}
        	}
        	
        	for(int i=0; i<remain+1; i++) {
        		deliveries[i] -= cap * count;
        		pickups[i] -= cap * count;
        	}
        	
        }
        
        return answer;
    }
}
