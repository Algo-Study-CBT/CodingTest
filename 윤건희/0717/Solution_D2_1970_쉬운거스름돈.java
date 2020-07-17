package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1970_쉬운거스름돈 {
	static int[] money = {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] ans = new int[8];
			for(int i = 0 ; i < 8; i++) {
				if(N >= money[i]) {
					int tmp = N / money[i];
					ans[i] = tmp;
					N -= tmp * money[i];
				}
			}
			
			
			System.out.println("#" + tc);
			for(int a : ans)System.out.print(a + " ");
			System.out.println();
			
		}
	}

}
