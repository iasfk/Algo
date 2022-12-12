import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		ArrayList<Integer> days = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			days.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		for (int i=0; i<x; i++) {
			sum += days.get(i);
		}
		int max = sum;
		int count = 1;
		int start = 0;
		while (start < n - x) {
			sum -= days.get(start);
			sum += days.get(start + x);
			
			start++;
			
			if (max == Math.max(max, sum)) {
				if (max == sum)
					count++;
			}else
				{max = sum;
				count = 1;}
		}
		if (max > 0) {
			System.out.println(max);
			if (count>0)
				System.out.println(count);
		} else
			System.out.println("SAD");
	}
}
