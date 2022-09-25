package kakaoTest;

public class Q6 {
	static String result = "impossible";
	 // d l r u	사전순이라
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, -1, 1, 0};
	static String[] ds = {"d", "l", "r", "u"};
 	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		int n = 3;
		int m = 4;
		int x = 2;
		int y = 3;
		int r = 3;
		int c = 1;
		int k = 5;

		sb.append(solution(n, m, x, y, r, c, k));
		System.out.println(sb);
	}
	
	public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        System.out.println(n +" "+ m +" "+ x+" "+ y+" "+ r+" "+ c+" "+ k);
        // d l r u	사전순이라
        if((Math.abs(x-r) + Math.abs(y-c)) <= k) {
        	if((Math.abs(x-r) + Math.abs(y-c) - k)%2 == 0) {
        		dfs(n, m, x, y, r, c, k, "",  0);
        	}
        }
        
        answer = result;
        return answer;
    }

	static void dfs(int n, int m, int x, int y, int r, int c, int k, String temp, int depth) {
		System.out.println(n +" "+ m +" "+ x+" "+ y+" "+ r+" "+ c+" "+ k +" "+ temp +" "+ depth);
		System.out.println(temp);
		if(!result.equals("impossible")) {
			
			return;
		}
		
		if(x == r && y == c) {
			if(depth == k) {
				result = temp;
				return;
			}
			
			return;
		}
		
		if((Math.abs(x-r) + Math.abs(y-c)) + depth == k) {
			String temp_new = temp;
			
			if(x > r) {
				for(int i=0; i<x-r; i++) {
					temp_new += "d";
				}
			}
			
			if(c < y) {
				for(int i=0; i<y-c; i++) {
					temp_new += "l";
				}
			}
			
			if(c > y) {
				for(int i=0; i<c-y; i++) {
					temp_new += "r";
				}
			}
			
			if(x < r) {
				for(int i=0; i<r-x; i++) {
					temp_new += "u";
				}
			}
			
			dfs(n, m, r, c, r, c, k, temp_new, k);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(i==0 && x==n) {
				continue;
			}
			
			if(i==1 && y == 1) {
				continue;
			}
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx == r && ny == c) {
				nx = x;
				ny = y;
				continue;
			}
			
			String temp_new = temp + ds[i];
			
			dfs(n, m, nx, ny, r, c, k, temp_new, depth+1);
			if(!temp.equals(temp_new)) {
				break;
			}
		}
	}
}
