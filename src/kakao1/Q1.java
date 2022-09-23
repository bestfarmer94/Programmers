package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] id_list = new String[n];
		
		for(int i=0; i<n; i++) {
			id_list[i] = br.readLine();
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] report = new String[m];
		
		for(int i=0; i<m; i++) {
			report[i] = br.readLine();
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i : solution(id_list, report, k)) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
	
//4
//muzi
//frodo
//apeach
//neo
//5
//muzi frodo
//apeach frodo
//frodo neo
//muzi neo
//apeach muzi
//2
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        
		int[] answer = new int[id_list.length];
        String[] report_distinct = Arrays.stream(report).distinct().toArray(String[]::new);
        
        int[][] report_2 = new int[report_distinct.length][2];
        int[] amount = new int[id_list.length];
        
        for(int i=0; i<report_distinct.length; i++) {
        	StringTokenizer st = new StringTokenizer(report_distinct[i]);
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	for(int j=0; j<id_list.length; j++) {
        		if(a.equals(id_list[j])) {
        			report_2[i][0] = j;
        		}
        		
        		if(b.equals(id_list[j])) {
        			report_2[i][1] = j;
        			amount[j]++;
        		}
        	}
        }
        
        for(int i=0; i<amount.length; i++) {
        	if(amount[i] >= k) {
        		for(int j=0; j<report_2.length; j++) {
        			if(report_2[j][1] == i) {
        				answer[report_2[j][0]]++;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
