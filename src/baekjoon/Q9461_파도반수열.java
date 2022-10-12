package Silver;

import java.util.Scanner;

public class Q9461_파도반수열 {
	public static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i =4; i<101; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int tc = sc.nextInt();
		for (int i =0; i<tc; i++) {
			int t = sc.nextInt();
			System.out.println(dp[t]);
		}//end for
	}//end main

}

//dp[n] = dp[n-2] + dp[n-3]
