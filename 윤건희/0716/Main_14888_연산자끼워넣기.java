package excersise0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] num_arr;
	static int[] cal;
	static int[] op;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_arr = new int[N];
		for(int i = 0; i < N;i++) {
			num_arr[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4]; // 연산자 배열
		int num_op = 0; // 연산자 개수 N - 1개
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
			num_op += op[i];
		} // 입력 끝
		
		cal = new int[num_op]; //연산자 배열
		dfs(0,num_op);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void dfs(int n, int num_op) {
		if(n == num_op) {//종료조건
			int tmp = num_arr[0]; //연산결과
			for(int i = 0 ; i < num_op; i++) {
				if(cal[i] == 0)tmp += num_arr[i+1];
				else if(cal[i] == 1)tmp -= num_arr[i+1];
				else if(cal[i] == 2)tmp *= num_arr[i+1];
				else if(cal[i] == 3)tmp /= num_arr[i+1];
			}
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}
		//dfs
		for(int i = 0; i < 4;i++) {
			if(op[i] > 0) {
				op[i]--;
				cal[n] = i;
				dfs(n+1, num_op);
				op[i]++;
			}
		}
	}
}
