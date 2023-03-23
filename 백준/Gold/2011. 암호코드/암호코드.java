import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.length() == 0)
		{
			System.out.println(0);
			return;
		}
		int[][] dp = new int[s.length()][2];
		
		//s의 크기만큼 dp를 만든다
		dp[0][0] = 1;
		dp[0][1] = 0;
		
		char pre = s.charAt(0);
		if (pre == '0')
		{
			System.out.println(0);
			return;
		}
		
		for (int i=1; i<s.length(); i++) {
			char target = s.charAt(i);
			if (target == '0') {
				if (pre == '0')
				{
					System.out.println(0);
					return;
				} else if (pre == '1' || pre == '2') {
					if ( i-2 == -1)
					{dp[i][1] = dp[0][0] + dp[0][1];}
					else
					dp[i][1] = (dp[i-2][0] + dp[i-2][1])% 1000000;
				}
			} else {
				int t = Integer.parseInt(pre+""+target);
//				System.out.println(target);
				if (t > 26)
				{
					dp[i][1] = 0;
					dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
				} else {
					dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
					if (pre != '0') {
					if ( i-2 == -1)
						{dp[i][1] = dp[0][0] + dp[0][1];}
					else
					dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 1000000;
					}
				}
			}
			pre = target;
		}
		
		System.out.println((dp[s.length()-1][0] + dp[s.length()-1][1])% 1000000);
		
		
	}
}