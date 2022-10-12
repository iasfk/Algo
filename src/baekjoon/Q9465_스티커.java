package Silver;

import java.util.Scanner;

public class Q9465_스티커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i =0; i<tc; i++) {
			int t = sc.nextInt();
			int[][] map = new int[2][t+1];
			for (int j =0; j<2; j++) {
				for(int m = 1; m<=t; m++) {
					map[j][m] = sc.nextInt();
				}
			}//map 넣어주기
			int[][] dp = new int[2][t+1];
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for (int a = 2; a<=t; a++) {
				dp[0][a] = Math.max(dp[1][a-1], dp[1][a-2]) + map[0][a];
				dp[1][a] = Math.max(dp[0][a-1], dp[0][a-2]) + map[1][a];
			}
			
			System.out.println(Math.max(dp[0][t], dp[1][t]));

		}//end test case
	}
}

//dp[0][n] = Math.max(dp[1][n-1], dp[0][n-2]) + map[0][n];