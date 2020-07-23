package excersise0723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	static int N, M, res[], arr[];
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[N];
		visit = new boolean[N];
		for(int i = 0;i<N;i++) {
			arr[i] = i+1;
		}
		dfs(0,0);
	}
	public static void dfs(int v, int start) {
		if(v == M) {
			for(int i = 0 ; i < v;i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start ; i < N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				res[v] = arr[i];
				dfs(v+1, i+1);
				visit[i] = false;
			}
		}
	}
}
