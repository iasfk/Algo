import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int start = 1;
		int end = house[n - 1] - house[0] + 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int count = 1;
			int prehouse = house[0];
			
			for (int i = 0; i < n; i++) {
				if (house[i]-prehouse >= mid) {
					count++;
					prehouse = house[i];
				}
			}
			
			if (count >= c)
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		System.out.print(end);
	}
}
