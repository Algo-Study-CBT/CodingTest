package excersise0722;

import java.io.*;
import java.util.*;

public class Main_2638_치즈 {
	static int N, M, map[][], check[][];
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		int time = 0;
		boolean flag = true;
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(flag) {
			flag = false;
			
			set_check();// check 배열 초기화
			
			bfs();// bfs돌리기
			
			flag = exist_cheese(); // map에 치즈 유무 확인
			
			time++;// time 증가
		}
		System.out.println(time);
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int ni = tmp[0] + di[k];
				int nj = tmp[1] + dj[k];
				
				if(ni < 0 || nj < 0 || ni >= N || nj >= M)continue;
				
				if(map[ni][nj] == 0 && check[ni][nj] == 0) {
					check[ni][nj] = 1;
					q.add(new int[] {ni,nj});
				}
				if(map[ni][nj] == 1) { //치즈면
					check[ni][nj]++;
					if(check[ni][nj] >= 2)map[ni][nj] = 0;
				}
			}
		}
	}
	public static boolean exist_cheese() {
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ;j < M;j++) {
				if(map[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	public static void set_check() {
		for(int i = 0 ; i<N;i++) {
			Arrays.fill(check[i], 0);
		}
	}
	
}
