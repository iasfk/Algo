import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] name = new String[n+1];
		for (int i=1; i<=n; i++) {
			String str = br.readLine();
			map.put(str, map.size()+1);
			name[i] = str;
		}
		
		for (int i=0; i<m; i++) {
			String str = br.readLine();
			Character c = str.charAt(0);
			if (Character.isDigit(c)) {
				sb.append(name[Integer.parseInt(str)]).append('\n');
			} else
				sb.append(map.get(str)).append('\n');
		}
		System.out.println(sb);
	}
}
