import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] grapes = new int[n+1];
		for (int i=1; i<=n; i++) {
			grapes[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = grapes[1];
		if (n == 1)
		{
			System.out.print(dp[1]);
			return;
		}
		dp[2] = grapes[1]+grapes[2];
		if (n == 2)
		{
			System.out.print(dp[2]);
			return;
		}
		for (int i=3; i<=n; i++) {
			dp[i] = Math.max(Math.max(dp[i-3]+grapes[i-1]+grapes[i], dp[i-2]+grapes[i]), dp[i-1]);
		}
		int max = 0;
		for (int i=1; i<=n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
