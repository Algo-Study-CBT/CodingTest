package excersise0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <=10;tc++) {
			int garbage = Integer.parseInt(br.readLine());
			int ans = 0;
			String target = br.readLine();
			String in = br.readLine();
			
			for(int i = 0 ; i <= in.length() - target.length();i++) {
				if(target.equals(in.substring(i,i+target.length())))ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
