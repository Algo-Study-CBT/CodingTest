package excersise0723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static int N, M, res[], arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = i+1;
		}
		dfs(0);
		System.out.println(sb.toString());
	}
	public static void dfs(int v) {
		if(v == M) {
			for(int i = 0; i < v;i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N;i++) {
			res[v] = arr[i];
			dfs(v+1);
		}
	}

}
