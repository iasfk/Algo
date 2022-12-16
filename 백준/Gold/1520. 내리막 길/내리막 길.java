import java.util.*;
import java.io.*;

public class Main {
	static int map[][], dp[][];
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int m,n, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dp = new int[m][n];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		dfs(new Node(0,0));
		
		System.out.println(dp[0][0]);
	}
	
	static int dfs(Node nd) {
		if (nd.x == m-1 && nd.y == n-1)
			return 1;
		
		if (dp[nd.x][nd.y] != -1)
			return dp[nd.x][nd.y];
		
		dp[nd.x][nd.y] = 0;
		
		
		for (int i=0; i<4; i++) {
			int dr = nd.x + dx[i];
			int dc = nd.y + dy[i];
			
			if (!(dr>=0 && dc >=0 && dr <m && dc < n))
				continue;
			
			if (map[dr][dc] >= map[nd.x][nd.y])
				continue;
			
			dp[nd.x][nd.y] += dfs(new Node(dr,dc));
		}
		
		return dp[nd.x][nd.y];
	}
	
	static class Node {
		int x;
		int y;
		Node (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
