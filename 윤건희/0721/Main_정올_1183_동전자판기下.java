package excersise0721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기下 {
	static int[] value = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		int tot = 0; // 가진 동전 합친 금액
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] coins = new int[6]; // 입력 동전 개수
		int[] cnt_arr = new int[6]; // 출력 동전 개수
		for (int i = 0; i < 6; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
			tot = tot + value[i] * coins[i];
		} // 세팅 끝
		int sum = tot - w; //이제 sum 갖고 문제를 풀어나갈거
		// 이제부터 이전 문제들처럼 sum 값을 가진동전 중 가장 적은 수로 만들면 될듯
		
		for(int i = 0 ; i < 6;i++) {
			int cnt = Math.min(coins[i], sum / value[i]); // 가지고있는동전개수와 사용할 개수 비교 
			sum = sum - value[i] * cnt;
			cnt_arr[i] = coins[i] - cnt; // 결과 배열에 바로 저장
		}
		
		int res = 0; // 최종결과 출력
		for(int i = 0 ; i < 6;i++) {
			res += cnt_arr[i];
		}
		System.out.println(res);
		for(int a : cnt_arr)System.out.print(a + " ");
	}

}
