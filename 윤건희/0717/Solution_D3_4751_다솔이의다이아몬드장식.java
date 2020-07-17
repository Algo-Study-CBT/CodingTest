package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_4751_다솔이의다이아몬드장식 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String in = br.readLine();
			StringBuilder sb1 = new StringBuilder(".");
			StringBuilder sb2 = new StringBuilder(".");
			StringBuilder sb3 = new StringBuilder("#");
			
			for(int i = 0 ; i < in.length();i++) {
				sb1.append(".#..");
				sb2.append("#.#.");
				sb3.append("." + in.charAt(i) + ".#");
			}
			System.out.println(sb1);
			System.out.println(sb2);
			System.out.println(sb3);
			System.out.println(sb2);
			System.out.println(sb1);
		}
	}

}
