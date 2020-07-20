package excersise0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		for(int i = 0 ; i < N;i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i = N-1; i >=0; i--) {
			if(K >= money[i]) {
				cnt += K / money[i];
				K = K % money[i];
			}
		}
		System.out.println(cnt);
	}

}
