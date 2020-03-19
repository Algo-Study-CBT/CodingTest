import java.io.*;
import java.util.*;

public class Main{
	static int dy[]= {-1,-1,-1,0,1,1,1,0};
	static int dx[]= {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException{
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st=new StringTokenizer(br.readLine());
	  int n=Integer.parseInt(st.nextToken());
	  int m=Integer.parseInt(st.nextToken());
	  int k=Integer.parseInt(st.nextToken());
	  int map[][]=new int[n][n];//양분
	  int A[][]=new int[n][n];//추가될 양분
	  PriorityQueue<Integer> tree[][]=new PriorityQueue[n][n];
	  for(int i=0;i<n;i++) {
		  Arrays.fill(map[i], 5);
		  st=new StringTokenizer(br.readLine());
		  for(int j=0;j<n;j++) {
			  A[i][j]=Integer.parseInt(st.nextToken());
			  tree[i][j]=new PriorityQueue<Integer>();
		  }
	  }
	  for(int i=0;i<m;i++) {
		  st=new StringTokenizer(br.readLine());
		  int y=Integer.parseInt(st.nextToken())-1;
		  int x=Integer.parseInt(st.nextToken())-1;
		  int age=Integer.parseInt(st.nextToken());
		  tree[y][x].add(age);
	  }
	  
	  Queue<Integer> live=new LinkedList<Integer>();
	  int dead=0;
	  for(int t=0;t<k;t++) {
		  for(int y=0;y<n;y++) {
			  for(int x=0;x<n;x++) {
				  dead=0;
				  //봄
				  while(!tree[y][x].isEmpty()) {
					  int p=tree[y][x].poll();
					  if(map[y][x]>=p) {
						  map[y][x]-=p;
						  live.add(p+1);
					  }else dead+=p/2;
				  }
				 while(!live.isEmpty()) tree[y][x].add(live.poll());
				  
				  //여름
				  map[y][x]+=dead;
				  
				  //겨울
				  map[y][x]+=A[y][x];
			  }
		  }
		  for(int y=0;y<n;y++) {
			  for(int x=0;x<n;x++) {
				  if(tree[y][x].size()==0) continue;
				  for(int val:tree[y][x]) {
					  if(val%5==0) {
						  for(int i=0;i<8;i++) {
							  int ny=y+dy[i];
							  int nx=x+dx[i];
							  if(ny>=0&&nx>=0&&ny<n&&nx<n) {
								  tree[ny][nx].add(1);
							  }
						  }
						  
					  }
				  }
			  }
		  }
	  }
	  int answer=0;
	  for(int y=0;y<n;y++) {
		  for(int x=0;x<n;x++) {
			  answer+=tree[y][x].size();
		  }
	  }
	  System.out.println(answer);
	  
	  
	  
	}
}
