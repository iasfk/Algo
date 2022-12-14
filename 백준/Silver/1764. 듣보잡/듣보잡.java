
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<>();
		PriorityQueue<String> list = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		for (int i = 0; i<m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				list.add(str);
			}
		}

		System.out.println(list.size());
		
		while (!list.isEmpty()) {
			sb.append(list.poll()).append('\n');
		}
		
		System.out.println(sb);
	}
}
