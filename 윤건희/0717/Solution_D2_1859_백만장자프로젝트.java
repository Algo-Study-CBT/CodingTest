package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}//세팅끝
			long gold = 0;
			int max = arr[N-1];
			for(int i = N-1; i >= 0; i--) {
				if(max >= arr[i])gold = gold +(max-arr[i]);
				else max = arr[i];
			}
			System.out.println("#" + tc + " " + gold);
		}
	}

}
