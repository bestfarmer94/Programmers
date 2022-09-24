package kakaoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q3 {

	static int[] sale;
	static ArrayList<Plus> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000, 9000};
		
		sb.append(solution(users, emoticons));
		System.out.println(sb);
		br.close();
	}

	public static int[] solution(int[][] users, int[] emoticons) {
		result = new ArrayList<Plus>();
        sale = new int[emoticons.length];
        Arrays.fill(sale, 10);
        
        dfs(users, emoticons, 0);
        int[] answer = {result.get(0).number, result.get(0).money};
        return answer;
    }
	
	static void dfs(int[][] users, int[] emoticons , int depth) {
		
		if(depth == emoticons.length) {
			int total = 0;
			int number = 0;
			
			for(int i=0; i<users.length; i++) {
				int money = 0;
				
				for(int j=0; j<emoticons.length; j++) {
					if(sale[j] >= users[i][0]) {
						money += emoticons[j] * (100 - sale[j]) / 100;
					}
				}
				
				if(money >= users[i][1]) {
					number++;
				}else {
					total += money;
				}
			}
			
			System.out.println(total + " " + number);
			result.add(new Plus(number, total));
			
			if(result.size() > 1) {
				Collections.sort(result);
				result.remove(1);
			}
			
			return;
		}
		
		for(int i=10; i<=40; i+=10) {
			sale[depth] = i;
			dfs(users, emoticons, depth+1);
			sale[depth] = 10;
		}
	}
}

class Plus implements Comparable<Plus>{
	
	int number;
	int money;
	
	public Plus(int number, int money) {
		this.number = number;
		this.money = money;
	}

	@Override
	public int compareTo(Plus o) {
		
		if(o.number == this.number) {
			return o.money - this.money;
		}
		return o.number - this.number;
	}
}
