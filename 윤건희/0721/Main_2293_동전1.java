package excersise0721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		// i↓ 	 1 2 3 4 5 6 7 8 9 10 <- j
		// 1 	 1 1 1 1 1 1 1 1 1 1
		// 2 	 0 1 1 2 2 3 3 4 4 5
		// 5 	 0 0 0 0 1 1 2 2 3 4
		// res 	[1 2 2 3 4 5 6 7 8 10]
		int[] res = new int[k + 1];
		res[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				res[j] += res[j - coin[i]];
			}
		}
		System.out.println(res[k]);

	}

}
