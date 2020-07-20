package excersise0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		for(int i = 0; i < N;i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		
		int weight = 0;
		for(int i = N-1; i >= 0; i--) {
			weight = Math.max(weight, rope[i] * (N-i)); // 현재로프 무게 x 개수  , 이전 로프 무게 x 개수 비교
		}
		System.out.println(weight);
	}
}
