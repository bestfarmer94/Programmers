package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		sb.append(solution(s));
		System.out.println(sb);
		br.close();
	}
	
	
	public static String solution(String s) {
        String answer = "";
        
        String[] a = s.split(" ");
        int[] num = new int[a.length];
        
        for(int i=0; i<a.length; i++) {
        	num[i] = Integer.parseInt(a[i]);
        }
        
        Arrays.sort(num);
        
        answer = num[0] + " " + num[num.length-1];
        return answer;
    }
}