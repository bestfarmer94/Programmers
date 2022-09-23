package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q6 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(),",");
			
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int o = Integer.parseInt(br.readLine());
		int[][] skill = new int[o][6];
		
		for(int i=0; i<o; i++) {
			st = new StringTokenizer(br.readLine(),",");
			for(int j=0; j<6; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sb.append(solution(board, skill));
		System.out.println(sb);
		br.close();
	}
	
//4 5
//5,5,5,5,5
//5,5,5,5,5
//5,5,5,5,5
//5,5,5,5,5
//4
//1,0,0,3,4,4
//1,2,0,2,3,2
//2,1,0,3,1,2
//1,0,1,3,3,1
	
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
//        for(int i=0; i<skill.length; i++) {
//    		for(int j=0; j<board.length; j++) {
//    			if(j < skill[i][1]) {
//    				continue;
//    			}
//    			
//    			if(j > skill[i][3]) {
//    				break;
//    			}
//    			
//    			for(int k=0; k<board[j].length; k++) {
//    				if(k < skill[i][2]){
//        				continue;
//        			}
//    				
//    				if(k > skill[i][4]) {
//        				break;
//        			}
//    				
//    				if(skill[i][0] == 1) {
//    					board[j][k] -= skill[i][5];
//    				}else {
//    					board[j][k] += skill[i][5];
//    				}
//    			}
//    		}
//        	
//        }
//        
//        for(int i=0; i<board.length; i++) {
//        	for(int j=0; j<board[i].length; j++) {
//        		if(board[i][j] > 0) {
//        			answer++;
//        		}
//        	}
//        }
        
        
        return answer;
    }

}
