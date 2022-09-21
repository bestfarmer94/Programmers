package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(solution(arr));
		System.out.println(sb);
		br.close();
	}
	
	
	public static double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++) {
        	sum += arr[i];
        }
        
        answer = (double) sum/arr.length;
        
        return answer;
    }
}