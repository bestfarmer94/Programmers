package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8 {

	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][];
		
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[i+1];
			for(int j=0; j<=i; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			triangle[i] = arr;
		}
		
		sb.append(solution(triangle));
		System.out.println(sb);
		br.close();
	}
	
	
	public static int solution(int[][] triangle) {
        int answer = 0;
        answer = find_max(triangle.length-1, triangle);
        return answer;
    }
	
	
	static int find_max(int depth, int[][] triangle) {
		
		if(depth == 0) {
			return triangle[0][0];
		}
		
		for(int i=0; i<depth; i++) {
			triangle[depth-1][i] += Math.max(triangle[depth][i], triangle[depth][i+1]);
		}
		
		return find_max(depth-1, triangle);
	}
}