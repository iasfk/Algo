import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
		
		int[] block = new int[W], left = new int[W], right = new int[W];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, block[i]);
			left[i] = max;
		}
		
		max = 0;
		for (int i=W-1; i>=0; i--) {
			max = Math.max(max, block[i]);
			right[i] = max;
		}
		
		max = 0;
		for (int i=0; i<W; i++) {
			max += Math.min(right[i], left[i]) - block[i];
		}
		
		System.out.println(max);
		
	}
}