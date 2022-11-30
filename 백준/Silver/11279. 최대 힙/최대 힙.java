import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			switch (k) {
			case 0 :
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
				break;
			default :
				pq.add(k);
			}
			
		}
		
		System.out.println(sb);
	}
}
