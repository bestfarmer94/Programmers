package kakaoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		sb.append(solution(today, terms, privacies));
		System.out.println(sb);
		br.close();
	}
	
	public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        StringTokenizer st;
        
        String[][] terms_new = new String[terms.length][2];
        
        for(int i=0; i<terms.length; i++) {
        	st = new StringTokenizer(terms[i]);
        	terms_new[i][0] = st.nextToken();
        	terms_new[i][1] = st.nextToken();
        }
        
        int[] privacies_new = new int[privacies.length];
        
        for(int i=0; i<privacies.length; i++) {
        	st = new StringTokenizer(privacies[i]);
        	
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	for(int j=0; j<terms_new.length; j++) {
        		if(b.equals(terms_new[j][0])) {
        			st = new StringTokenizer(a, ".");
        			String a_1 = st.nextToken();
        			String a_2 = st.nextToken();
        			String a_3 = st.nextToken();
        			
        			privacies_new[i] = (Integer.parseInt(a_1)-2000)*12*28 
        					+ (Integer.parseInt(a_2)+Integer.parseInt(terms_new[j][1]))*28 
        					+ Integer.parseInt(a_3);

        		}
        	}
        }
        
        st = new StringTokenizer(today, ".");
    	String today_1 = st.nextToken();
    	String today_2 = st.nextToken();
    	String today_3 = st.nextToken();
    	
    	int today_new = (Integer.parseInt(today_1)-2000)*12*28 + Integer.parseInt(today_2)*28 
				+ Integer.parseInt(today_3);
    	
    	for(int i=0; i<privacies_new.length; i++) {
    		if(privacies_new[i] <= today_new) {
    			answer.add(i+1);
    		}
    	}
    	
        return answer;
    }
	
}