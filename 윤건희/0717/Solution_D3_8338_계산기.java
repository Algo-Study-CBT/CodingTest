package excersise0717;

import java.io.*;
import java.util.*;

public class Solution_D3_8338_계산기 {
	static int[] arr;
	static int N;
	static int res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<= T;tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i = 0 ; i < N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}//input end.
			
			res = arr[0];
			dfs(1,res);
			
			System.out.println("#" + tc + " " + res);
		}//tc
	}
	public static void dfs(int v, int val) {
		if(v == N) {
			res = Math.max(val, res);
			return;
		}
		dfs(v+1,val+arr[v]);
		dfs(v+1,val*arr[v]);
	}

}
