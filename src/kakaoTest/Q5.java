package kakaoTest;

import java.util.StringTokenizer;

public class Q5 {

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

	public static String[] solution(String[] commands) {
        String[] answer = {};
        
        String[][] arr = new String[51][51];
        StringTokenizer st;
        
        for(int i=0; i<commands.length; i++) {
        	st = new StringTokenizer(commands[i]);
        	String command = st.nextToken();
        	
        	if(command.equals("UPDATE")) {
        		String a1 = st.nextToken();
        		String a2 = st.nextToken();
        		String a3;
        		
        		if(st.hasMoreTokens()) {	// rc value
        			a3 = st.nextToken();
        			arr[Integer.parseInt(a1)][Integer.parseInt(a2)] = a3;	
        		}else {
        			for(int j=0; j<51; j++) {	// value1 value2
        				for(int k=0; k<51; k++) {
        					if(arr[j][k].equals(a1)) {
        						arr[j][k] = a2;
        					}
        				}
        			}
        		}
        	}
        	
        	if(command.equals("MERGE")) {
        		String r1 = st.nextToken();
        		String r2 = st.nextToken();
        		String c1 = st.nextToken();
        		String c2 = st.nextToken();
        	}
        	
        	if(command.equals(anObject))
        }
        return answer;
    }
	
}
