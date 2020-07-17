package excersise0717;

import java.io.*;
public class Solution_D2_2005_파스칼의삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] ans = new int[N][N];
			ans[0][0] = 1;
			for(int i = 0;i < N;i++) {
				for(int j = 0 ; j <=i; j++) {
					if(j == 0)ans[i][j] = 1;
					else if(i == j)ans[i][j] = 1;
					else ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
				}
			}
			System.out.println("#" + tc);
			for(int i = 0 ; i < N;i++) {
				for(int j = 0; j <=i;j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
