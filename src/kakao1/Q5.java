package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q5 {

	static int max = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] info = new int[n];
		
		for(int i=0; i<n; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] edges = new int[n-1][2];
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(solution(info, edges));
		System.out.println(sb);
		br.close();
	}
	
	public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        ArrayList<Integer> go = new ArrayList<Integer>();
        go.add(0);
        sheep_wolf(info, edges, go, 0, 1, 0);
        answer = max;
        return answer;
    }
	
//12
//0 0 1 1 1 0 1 0 1 0 1 1
//0 1
//1 2
//1 4
//0 8
//8 7
//9 10
//9 11
//4 3
//6 5
//4 6
//8 9
	
	static void sheep_wolf(int[] info, int[][] edges, ArrayList<Integer> go, int now, int sheep, int wolf) {
		
		if(sheep > max) {
			max = sheep;
		}
		
		if(sheep == wolf || go.isEmpty()) {
			
			return;
		}
		
		ArrayList<Integer> new_go = new ArrayList<Integer>();
		new_go = (ArrayList<Integer>) go.clone();
		new_go.remove(Integer.valueOf(now));	// Integer.valueOf(now), remove시 해당 값을 제거하고 싶다면 이걸로 해야한다.
		
		for(int i=0; i<edges.length; i++) {
			if(edges[i][0] == now) {
				new_go.add(edges[i][1]);
			}
		}
		
		for(int i=0; i<new_go.size(); i++) {
			if(info[new_go.get(i)] == 0) {
				sheep_wolf(info, edges, new_go, new_go.get(i), sheep+1, wolf);
			}else {
				sheep_wolf(info, edges, new_go, new_go.get(i), sheep, wolf+1);
			}
		}
		
		return;
	}
}
