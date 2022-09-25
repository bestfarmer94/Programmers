package kakaoTest;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q5 {

	// 문제가 자세히 생각나진 않음.
	static int[][] arr2;
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap"
				, "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean",
				"UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
				"UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
				"UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};

		sb.append(solution(commands));
		System.out.println(sb);
	}

	public static ArrayList<String> solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        
        String[][] arr = new String[51][51];
        arr2 = new int[51][51];
        for(int i=1; i<51; i++) {
        	for(int j=1; j<51; j++) {
        		arr[i][j] = " ";
        	}
        }
        
        int count = 1;
        for(int i=1; i<51; i++) {
        	for(int j=1; j<51; j++) {
            	arr2[i][j] = count;
            	count++;
        	}
        }
        StringTokenizer st;
        
        for(int i=0; i<commands.length; i++) {
        	System.out.println(commands[i]);
        	for(int j=1; j<6; j++) {
        		for(int k=1; k<6; k++) {
        			System.out.print(arr[j][k] + " ");
        		}
        		System.out.println();
        	}
        	st = new StringTokenizer(commands[i]);
        	String command = st.nextToken();
        	
        	if(command.equals("UPDATE")) {
        		String a1 = st.nextToken();
        		String a2 = st.nextToken();
        		String a3;
        		
        		if(st.hasMoreTokens()) {	// r c value
        			a3 = st.nextToken();
        			
        			int x = Integer.parseInt(a1);
        			int y = Integer.parseInt(a2);
        			
        			if(arr2[x][y] == 50*(x-1) + y) {
        				arr[x][y] = a3;
        			}else {
        				arr[(arr2[x][y]/50) +1][arr2[x][y]%50] = a3;
        			}
        		}else {
        			for(int j=1; j<51; j++) {	// value1 value2
        				for(int k=1; k<51; k++) {
        					if(arr[j][k] != " ") {
            					if(arr[j][k].equalsIgnoreCase(a1)) {
            						arr[j][k] = a2;
            					}
        					}
        				}
        			}
        		}
        	}
        	
        	if(command.equals("MERGE")) {
        		int r1 = Integer.parseInt(st.nextToken());
        		int c1 = Integer.parseInt(st.nextToken());
        		int r2 = Integer.parseInt(st.nextToken());
        		int c2 = Integer.parseInt(st.nextToken());
        		
        		for(int j=r1; j<=r2; j++) {
        			for(int k=c1; k<=c2; k++) {
        				arr2[j][k] = arr2[r1][c1];
        			}
        		}
        	}
        	
        	if(command.equals("UNMERGE")) {
        		int r1 = Integer.parseInt(st.nextToken());
        		int c1 = Integer.parseInt(st.nextToken());
        		arr[r1][c1] = arr[(arr2[r1][c1]/50) + 1][arr2[r1][c1] % 50];
        		unmerge(r1, c1, arr2[r1][c1]);
        	}
        	
        	if(command.equals("PRINT")) {
        		int r1 = Integer.parseInt(st.nextToken());
        		int c1 = Integer.parseInt(st.nextToken());
        		
        		if(arr2[r1][c1] == 50*(r1-1)+c1) {
        			answer.add(arr[r1][c1]);
        		}else {
        			answer.add(arr[(arr2[r1][c1] / 50) +1][arr2[r1][c1] % 50]);
        		}
        	}
        }
        
        return answer;
    }
	
	static void unmerge(int x, int y, int unmerge_num) {
		if(arr2[x][y] == unmerge_num) {
			arr2[x][y] = 50*(x-1)+y;
			
			unmerge(x-1, y, unmerge_num);
			unmerge(x, y-1, unmerge_num);
			
			if(x<50) {
				unmerge(x+1, y, unmerge_num);
			}
			
			if(y<50) {
				unmerge(x, y+1, unmerge_num);
			}
		}
	}
}
