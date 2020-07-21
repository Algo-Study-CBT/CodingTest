package excersise0721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1];
		int[] arr = new int[k+1];
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		Arrays.fill(arr, 10001); // k보다큰수
		// i 	1 2 3 4 5 6 7 8 9 10 11 12 13 14 15	]j
		// 1	1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		// 5	- - - - 1 2 3 4 5 2  3  4  5  6  3 	
		// 12	- - - - - - - - - -  -  1  2  3  3
		// arr 	1 2 3 4 1 2 3 4 5 2  3  1  2  3  3
		arr[0] = 0;
		for(int i = 1; i <= n;i++) {
			for(int j = coin[i]; j <=k; j++) {
				arr[j] = Math.min(arr[j], arr[j-coin[i]] +1); //동전 수 = 이전갯수 + 1
			}
		}
		if(arr[k] == 10001)System.out.println(-1);
		else System.out.println(arr[k]);
	}
}
