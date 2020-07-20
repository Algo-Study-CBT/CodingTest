package excersise0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5585_거스름돈 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int change = 1000 - N;
		int cnt = 0;
		int[] coins = {1,5,10,50,100,500};
		for(int i = coins.length-1; i>=0; i--) {
			if(change / coins[i] > 0) {
				cnt += change / coins[i];
				change = change %coins[i];
			}
		}
		System.out.println(cnt);
	}

}
