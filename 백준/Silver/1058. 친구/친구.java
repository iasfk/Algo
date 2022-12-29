import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] friend = new int[51][51];
		// 입력 받음
		for (int i = 1; i <= n; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				friend[i][j] = str[j - 1] == 'Y' ? 1 : 51;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
				}
			}
		}
		
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (friend[i][j] == 2 || friend[i][j] == 1)
					cnt++;
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}