import java.io.*;
import java.util.*;

public class Main {
	static int m, n;
	static int arr[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		arr = new int[m];
		dfs(0);
		System.out.println(sb.toString());

	}
	static void dfs(int depth) {
		if (depth == m) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i =0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
