package kakao1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] fees = new int[4];
		
		for(int i=0; i<4; i++) {
			fees[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		String[] records = new String[n];
		
		for(int i=0; i<n; i++) {
			records[i] = br.readLine();
		}
		
		sb.append(solution(fees, records));
		System.out.println(sb);
		br.close();
	}
	
//180 5000 10 600
//9
//05:34 5961 IN
//06:00 0000 IN
//06:34 0000 OUT
//07:59 5961 OUT
//07:59 0148 IN
//18:59 0000 IN
//19:09 0148 OUT
//22:59 5961 IN
//23:00 5961 OUT
	
//120 0 60 591
//5
//16:00 3961 IN
//16:00 0202 IN
//18:00 3961 OUT
//18:00 0202 OUT
//23:58 3961 IN
	
//1 461 1 10
//1
//00:00 1234 IN
	
	public static ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        String[][] new_records = new String[records.length][3];
        int[] car_time = new int[10000];
        
//        TreeMap<String, Integer> map = new TreeMap<>();
//		  트리맵은 hashmap의 정렬 버전이다.
//        for(String record : records) {
//            String temp[] = record.split(" ");
//            int time = temp[2].equals("IN") ? -1 : 1;
//            time *= timeToInt(temp[0]);	그 사람은 따로 함수 만들어서 했음.
//            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
//        }
        
        for(int i=0; i<records.length; i++) {
        	new_records[i] = records[i].split(" ");
        	int time = Integer.parseInt(new_records[i][0].substring(0, 2))*60 
        			+ Integer.parseInt(new_records[i][0].substring(3,5));
        	
        	if(new_records[i][2].equalsIgnoreCase("IN")) {
        		if(time == 0) {
        			car_time[Integer.parseInt(new_records[i][1])] -= 123456789;
        		}else {
        			car_time[Integer.parseInt(new_records[i][1])] -= time;
        		}
        	}else {
        		car_time[Integer.parseInt(new_records[i][1])] += time;
        	}
        }
        
        for(int i=0; i<car_time.length; i++) {
        	
        	if(car_time[i] != 0) {
        		if(car_time[i] < -24*60) {
    				car_time[i] += 123456789;
    			}
        		
        		if(car_time[i] > 0) {
        			if(car_time[i] <= fees[0]) {
        				answer.add(fees[1]);
        			}else {
        				answer.add(fees[1] + (int)Math.ceil((double)(car_time[i] - fees[0])/fees[2])*fees[3]);
        			}
        		}else {
        			car_time[i] += (24*60 -1);
        			if(car_time[i] <= fees[0]) {
        				answer.add(fees[1]);
        			}else {
        				answer.add(fees[1] + (int)Math.ceil((double)(car_time[i] - fees[0])/fees[2])*fees[3]);
        			}
        		}
        	}
        }
        
        return answer;
    }
	
}
