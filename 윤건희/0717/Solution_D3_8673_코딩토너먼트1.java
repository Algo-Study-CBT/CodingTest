package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_8673_코딩토너먼트1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int n = (int) Math.pow(2, K);
			int ans = 0;

			st = new StringTokenizer(br.readLine());

			Queue<Integer> tournament = new LinkedList<Integer>();
			Queue<Integer> boring = new LinkedList<Integer>();

			for (int i = 0; i < n; i++) {
				tournament.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n - 1; i++) {
				int a = tournament.poll();
				int b = tournament.poll();
				boring.add(Math.abs(a - b));
				tournament.add(Math.max(a, b));
			}
			while (!boring.isEmpty())
				ans += boring.poll();

			System.out.println("#" + tc + " " + ans);
		}
	}

}
