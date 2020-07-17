package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1954_달팽이숫자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int turn = 1;
			int x = -1, y = 0;
			int cnt = 1;
			int tmp = N;
			while (tmp > 0) {
				for (int i = 0; i < tmp; i++) {
					x = x + turn;
					map[y][x] = cnt;
					cnt++;
				}
				tmp--;
				for (int i = 0; i < tmp; i++) {
					y = y + turn;
					map[y][x] = cnt;
					cnt++;
				}
				turn *= -1;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
