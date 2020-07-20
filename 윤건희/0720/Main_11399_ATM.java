package excersise0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[N];
		for(int i = 0; i < N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		int sum = 0;
		int res = 0;
		for(int i = 0; i < N;i++) {
			sum += people[i];
			res += sum;
		}
		System.out.println(res);
	}

}
