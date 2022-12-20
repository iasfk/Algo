import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<n; tc++) {
			HashMap<String, Integer> map = new HashMap<>();
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i <m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();
				map.put(str, map.getOrDefault(str, 0) +1);
			}
			int sum = 1;
			
			Set<String> s = map.keySet();
			
			for (String cloth : s) {
				sum *= map.get(cloth)+1;
			}
			
			sb.append(sum-1).append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}