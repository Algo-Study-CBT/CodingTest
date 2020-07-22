package excersise0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int N,M,V;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		dfs(V);
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
		
	}
	public static void dfs(int level) {
		visit[level] = true;
		System.out.print(level + " ");
		for(int i = 1 ; i <= N;i++) {
			if(map[level][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	public static void bfs(int level) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(level);
		visit[level] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");
			for(int i = 1 ; i <=N;i++ ) {
				if(map[tmp][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}

}
