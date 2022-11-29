import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				stk.add(Integer.parseInt(st.nextToken()));
				break;
			case "top" :
				sb.append(stk.isEmpty() ? -1 : stk.peek()).append('\n');
				break;
			case "size" :
				sb.append(stk.size()).append('\n');
				break;
			case "empty" :
				sb.append(stk.isEmpty() ? 1 : 0).append('\n');
				break;
			case "pop" :
				sb.append(stk.isEmpty() ? -1 : stk.pop()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}
