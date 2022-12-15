import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("all")) {
				set.clear();
				for (int a = 1; a <=20; a++) {
					set.add(a);
				}
			} else if (str.equals("empty")){
				set.clear();
			} else {
				int t = Integer.parseInt(st.nextToken());
				if (str.equals("add"))
					set.add(t);
				else if (str.equals("remove")) {
					if (set.contains(t))
						set.remove(t);
				} else if (str.equals("check")) {
					if (set.contains(t))
						sb.append(1).append('\n');
					else
						sb.append(0).append('\n');
				} else if (str.equals("toggle")) {
					if (set.contains(t))
						set.remove(t);
					else
						set.add(t);
				}
			}
				
		}
		
		System.out.println(sb);
		br.close();
	}
}
