package excersise0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_16637_괄호추가하기 {
	static int N, max = Integer.MIN_VALUE;
	static char[] in;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = br.readLine().toCharArray();
		visit = new boolean[N];
		//세팅 끝
		
		dfs(1);
		System.out.println(max);
	}
	public static void dfs(int level) {
		if(level == N) {//종료
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < N; i+=2) {
				if(visit[i]) {
					list.add(calc(in[i]-'0',in[i+1],in[i+2]-'0'));
					i+=2;
				}else list.add(in[i]-'0');
			}
			
			int res = list.get(0);
			int idx = 0; // 인덱스
			
			for(int i = 1; i < N; i+=2) {
				if(!visit[i]) {
					res = calc(res,in[i],list.get(++idx));
				}
			}
			max = Math.max(res, max);
			
			return;
		}
		if(!visit[level-1] && !visit[level+1]) {
			for(int i = -1; i <= 1; i++)visit[level+i] = true;
			dfs(level+2);
			for(int i = -1; i <= 1; i++)visit[level+i] = false;
		}
		dfs(level+2);
	}
	public static int calc(int a, char op, int b) {
		if(op == '+')return a+b;
		else if(op == '-')return a-b;
		else return a*b;
	}
}
