package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1284_수도요금경쟁 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int A = W * P;
			int B;
			int min = Integer.MAX_VALUE;

			if (W <= R)
				B = Q;
			else
				B = (W - R) * S + Q;
			if (A < B)
				min = A;
			else
				min = B;
			System.out.println("#" + tc + " " + min);
		}
	}
}
