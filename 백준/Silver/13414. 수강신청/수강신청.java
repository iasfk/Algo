import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<m; i++) {
			String a = br.readLine();
			if (set.contains(a)) {
				set.remove(a);
			} 
			set.add(a);
		}
		int count = 0;
		
		for (String s : set) {
			sb.append(s).append('\n');
			count ++;
			if (count == n)
				break;
		}
		System.out.println(sb);
	}
}