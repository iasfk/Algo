import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		int cnt = n;
		for (int i=0; i<m; i++) {
			String[] str = br.readLine().split(",");
			for (String s : str) {
				if (set.contains(s)) 
					{set.remove(s);
					cnt--;}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}