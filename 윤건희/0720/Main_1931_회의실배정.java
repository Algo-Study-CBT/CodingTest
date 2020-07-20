package excersise0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Meeting[] arr = new Meeting[N];
		for(int i =0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Meeting(start, end); 
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		int tmp_end = 0;
		for(int i = 0 ; i < N;i++) {
			if(arr[i].start >= tmp_end) {
				cnt++;
				tmp_end = arr[i].end;
			}
		}
		System.out.println(cnt);
	}
	
}
class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		int t = this.end - o.end;
		if(t == 0)t = this.start - o.start;
		return t;
	}
}
