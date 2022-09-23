package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4 {

	static int[] score;
	static int max;
	static int[] answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] info = new int[11];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<11; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i: solution(n, info)) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
		br.close();

	}

	
	public static int[] solution(int n, int[] info) {
        
		answer = new int[] {-1};
        score = new int[11];
        max = 1;
        visited = new boolean[11];
        
        dfs(info, 0, n);
        
        return answer;
    }
	
	
	static void dfs(int[] info, int count, int n) {
		
		if(count == n) {
			int ryan = 0;
			int apeach = 0;
			
			for(int i=0; i<11; i++) {
				
				if(info[i] == 0 && score[i] == 0) {
					continue;
				}
				
				if(info[i] >= score[i]) {
					apeach += 10-i;
				}else {
					ryan += 10-i;
				}
			}
			
			if(ryan - apeach > max) {
				answer = score.clone();		// clone 으로 해야 한다. 안그러면 score를 그냥 똑같이 따라 다닌다.
				max = ryan - apeach;
			}else if(ryan - apeach == max) {
				for(int i=10; i>=0; i--) {
					if(score[i] > answer[i]) {
						answer = score.clone();
						break;
					}else if(answer[i] > score[i]){
						break;
					}
				}
			}
			
			return;
		}
		
		for(int i=0; i<11; i++) {
			int remain = n - count;
			
			if(i != 10) {
				if(!visited[i] && score[i] <= info[i] && remain >= info[i] + 1) {
					score[i] = info[i] + 1;
					if(count == 0) {
						visited[i] = true;
					}
					dfs(info, count+info[i]+1, n);
					score[i] = 0;
				}
			}else {
				score[i] = remain;
				dfs(info, n, n);
				score[i] = 0;
			}
		}
	}
}
